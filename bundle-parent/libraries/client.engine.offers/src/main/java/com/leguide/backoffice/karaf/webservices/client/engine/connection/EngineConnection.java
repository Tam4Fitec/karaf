package com.leguide.backoffice.karaf.webservices.client.engine.connection;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.webservices.client.engine.domain.request.Request;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineConnectionException;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineIOException;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineJaxbException;

/**
 * The Class EngineConnection.
 * 
 * This class represents a connection engine and the associated services
 * 
 * @author frederic.quinet
 */

public class EngineConnection {

    /** Logger for this class. */
    private static Logger logger = LoggerFactory.getLogger(EngineConnection.class);

    /** The Constant ENGINE_CHAR_ENCODING. */
    public static final String ENGINE_CHAR_ENCODING = "UTF-8";

    /**
     * This is the time (in millisecond) between two readings if the reader is
     * waiting production.
     */
    private int timeWaitingRead = 1500;

    /** The host. */
    private String host;

    /** The port. */
    private int port;

    /** The socket. */
    private Socket socket;

    private int tentative = 1;

    private int maxTentative = 4;

    /** Socket Timeout in ms **/
    private int socketTimeout = 50000;

    /**
     * Instantiates a new engine connection.
     */
    public EngineConnection() {
        super();
    }

    /**
     * Instantiates a new engine connection.
     * 
     * @param host the host
     * @param port the port
     */
    public EngineConnection(String host, int port) {
        this.port = port;
        this.host = host;
    }

    /**
     * Instantiates a new engine connection.
     * 
     * @param host the host
     * @param port the port
     */
    public EngineConnection(String host, int port, int timeWaitingRead) {
        this.port = port;
        this.host = host;
        this.timeWaitingRead = timeWaitingRead;
    }

    /**
     * Connect.
     * 
     * @throws EngineConnectionException if the connection can't be established
     */
    public void connect() throws EngineConnectionException {

        logger.debug("connecting to the engine :host=[{}] port=[{}]", this.host, this.port);

        if (this.socket != null) {
            logger.debug("engine already connect");
            logger.debug("socket already open");
            return;
        }
        try {
            this.socket = new Socket(this.host, this.port);
            this.socket.setSoTimeout(socketTimeout);
            logger.debug("connected to the engine :host=[{}] port=[{}]", this.host, this.port);
            logger.debug("socket open");
        } catch (IOException e) {
            if (tentative < maxTentative) {
                logger.warn("Error connecting to the engine {}:{}", this.host, this.port);
                tentative++;
                logger.info("new tentative of connexion : [{}] of [{}]", tentative, maxTentative);
                connect();
            } else {
                logger.warn("unable connecting to the engine {}:{}", this.host, this.port);
                throw new EngineConnectionException("Unable connection to the engine", e);
            }
        }
    }

    /**
     * Disconnect.
     * 
     * @throws EngineConnectionException if the connection can't be established
     */
    public void disconnect() throws EngineConnectionException {
        if (this.socket != null) {
            try {
                this.socket.shutdownOutput();
                this.socket.shutdownInput();
                this.socket.close();
                logger.debug("socket closed");
                logger.debug("engine disconnected");
            } catch (IOException e) {
                logger.error("Error disconnecting to the engine [{}]:[{}]", this.host, this.port);
                throw new EngineConnectionException(e);
            }
            this.socket = null;
        } else {
            logger.debug("connection instance to [{}]:[{}] is already closed", this.host, this.port);
        }
    }

    /**
     * Gets the output stream.
     * 
     * @return the output stream
     * @throws EngineConnectionException if the connection can't be established
     * @throws EngineIOException if the IO stream can't be write
     */
    public OutputStream getOutputStream() throws EngineConnectionException, EngineIOException {
        try {
            connect();
            return this.socket.getOutputStream();
        } catch (IOException e) {
            logger.error("Error retrieving the engine's socket output stream : [{}]", e.getMessage(), e);
            throw new EngineIOException("can not retrieve the outputStream for this socket", e);
        }
    }

    /**
     * Gets the input stream.
     * 
     * @return the input stream
     * @throws EngineConnectionException if the connection can't be established
     * @throws EngineIOException if the IO stream can't be read
     */
    public InputStream getInputStream() throws EngineConnectionException, EngineIOException {
        try {
            if (this.socket != null) {
                return this.socket.getInputStream();
            } else {
                logger.error("can not get InputStream while socket is not open");
                throw new EngineConnectionException("socket is not open for get this inputStream");
            }
        } catch (IOException e) {
            logger.error("Error retrieving the engine's socket input stream", e);
            throw new EngineIOException("can not retrieve the inputStream for this socket", e);
        }
    }

    /**
     * Post request to the engine.
     * 
     * @param query the query
     * @throws EngineConnectionException if the connection can't be established
     * @throws EngineIOException if the IO stream can't be write
     * @throws EngineJaxbException if the stream is not writable to xml
     */
    public void postRequest(Request query, JAXBContext context) throws EngineConnectionException, EngineIOException, EngineJaxbException {

        if (logger.isDebugEnabled()) {
            String xmlQuery;
            try {
                xmlQuery = marshallQuery(query, context);
                logger.debug("sending request on engineConnection : [{}]", xmlQuery);
            } catch (JAXBException e) {
                disconnect();
                logger.error("unable to marshal the request for the engine :[{}]", query.toString());
            }
        }

        BufferedOutputStream bos = new BufferedOutputStream(getOutputStream());
        try {

            marshallQuery(query, bos, context);
            bos.flush();

        } catch (IOException e) {
            logger.error("can't flush Engine Request to engine", e);
            throw new EngineIOException("can't flush request to this outputStream", e);
        } catch (JAXBException e) {
            disconnect();
            logger.error("Unable to marshal the request for the engine :[{}]", query.toString());
            throw new EngineJaxbException("Unable to marshal the request", e);
        }
    }

    /**
     * Gets the response.
     * 
     * @return the String response with XML engine format
     * @throws EngineConnectionException if the connection can't be established
     * @throws EngineIOException if the IO stream can't be read
     */
    public String getResponse() throws EngineConnectionException, EngineIOException {

        InputStream is = getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);

        byte[] cbuf = new byte[8];

        StringBuffer sbuff = new StringBuffer();
        int length = 0;
        int retry = 0;
        try {
            while (true) {
                if (bis.available() <= 0) {
                    logger.debug("InputStream unavailable");
                    try {
                        Thread.sleep(timeWaitingRead);
                        retry++;
                    } catch (InterruptedException e) {
                        logger.info("thread sleeping interupted : {}", e.getMessage());
                    }
                    if (retry > 20) {
                        throw new IOException("reading input stream - retries exhausted");
                    } else {
                        continue;    
                    }
                    
                }

                logger.debug("Input Stream ready");

                int nbRead = bis.read(cbuf, 0, 8);

                logger.debug("Charset : [{}]", ENGINE_CHAR_ENCODING);
                // Cast to char to retrieve values in character mode
                logger.debug("Engine Response Header :[{}{}{}{}]", new Object[] { (char) cbuf[3], (char) cbuf[2],
                        (char) cbuf[1], (char) cbuf[0] });

                if ((char) cbuf[3] == 'L' && (char) cbuf[2] == 'G' && (char) cbuf[1] == 'N' && (char) cbuf[0] == 'T') {

                    // On reverse les 4 bytes allant de l'index 4 à 7 parce que
                    // le moteur s'exprime en little endian
                    // (bit de poids faible numéroté à 0). La convention réseau
                    // est le big endian : bit de poids fort à 0.

                    byte[] cbufs = new byte[4];
                    for (int i = 0; i <= 3; i++) {
                        cbufs[i] = cbuf[7 - i];
                    }

                    ByteBuffer bb = ByteBuffer.wrap(cbufs);
                    length = bb.getInt();

                    logger.debug("Engine Response Size = [" + length + "]");
                    int nbReadTotal = 0;
                    // logger.debug(" \\n length : [{}]",
                    // "\n".getBytes(Charset.forName(ENGINE_CHAR_ENCODING)).length);
                    while (nbReadTotal < length) {
                        byte[] byteBuffer = new byte[length];
                        nbRead = bis.read(byteBuffer, 0, length);

                        if (nbRead == -1) {
                            logger.debug("read waiting (no character for read, waiting producer)");
                            try {
                                Thread.sleep(timeWaitingRead);
                            } catch (InterruptedException e) {
                                logger.info("thread sleeping interupted : {}", e.getMessage());
                            }
                            continue;
                        } else {
                            String result = new String(byteBuffer, 0, nbRead, Charset.forName(ENGINE_CHAR_ENCODING));

                            logger.debug("result.length = [{}]", result.length());
                            logger.debug("number of byte read for this package = [{}]", nbRead);
                            sbuff.append(result);
                            logger.debug("sbuff = [{}]}", sbuff);
                            nbReadTotal += nbRead;
                            logger.debug("number total of byte read = [{}]", nbReadTotal);
                        }
                    }
                    break;
                }
            }
        } catch (IOException e) {
            logger.error("Unable to read the response stream", e);
            throw new EngineIOException("Unable to read the response stream", e);
        } finally {
            disconnect();
        }

        String xmlResponse = sbuff.toString();
        logger.debug("engine response = [{}]", xmlResponse);
        return xmlResponse;
    }

    /**
     * Gets the response using a BufferedReader
     * 
     * @return the String response with XML engine format
     * @throws EngineConnectionException if the connection can't be established
     * @throws EngineIOException if the IO stream can't be read
     */
    public String getResponseReadLine() throws EngineConnectionException, EngineIOException {

        InputStream is = getInputStream();

        StringBuffer sbuff = new StringBuffer();
        int retry = 0;
        try {
            while (true) {
                if (is.available() <= 0) {
                    logger.debug("InputStream unavailable");
                    try {
                        Thread.sleep(timeWaitingRead);
                        retry++;
                    } catch (InterruptedException e) {
                        logger.info("thread sleeping interupted : {}", e.getMessage());
                    }
                    if (retry > 20) {
                        throw new IOException("reading input stream - retries exhausted");
                    } else {
                        continue;    
                    }
                    
                }

                logger.debug("Input Stream ready");
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    sbuff.append(line);
                }
                break;
            }
        } catch (IOException e) {
            logger.error("Unable to read the response stream", e);
            throw new EngineIOException("Unable to read the response stream", e);
        } finally {
            disconnect();
        }

        String xmlResponse = sbuff.toString();
        logger.debug("engine response = [{}]", xmlResponse);
        return xmlResponse;
    }

    /**
     * Marshall query to the engine with outputStream.
     * 
     * @param requestObject the request object <? extends {@link Request}>
     * @param os the outputStream to the engine
     * @throws JAXBException If any unexpected problem occurs during the
     *             marshalling or initialization of JAXBcontext
     */
    protected void marshallQuery(final Request requestObject, final OutputStream os, JAXBContext context) throws JAXBException {
        Marshaller m = createMarshaller(context);//requestObject.getClass().getPackage().getName());
        m.marshal(requestObject, os);
    }

    /**
     * Marshall query for engine.
     * 
     * @param requestObject the request object <? extends {@link Request}>
     * @return the string with xml format
     * @throws JAXBException If any unexpected problem occurs during the
     *             marshalling or initialization of JAXBcontext
     */
    protected String marshallQuery(final Request requestObject, JAXBContext context) throws JAXBException {
        Marshaller m = createMarshaller(context);//requestObject.getClass().getPackage().getName());
        StringWriter sw = new StringWriter();
        m.marshal(requestObject, sw);
        sw.flush();
        return sw.toString();

    }

    /**
     * Creates the marshaller.
     * 
     * @param packageName the package name where will search the rootElement
     * @return the marshaller
     * @throws JAXBException if an error was encountered while creating the
     *             JAXBContext or the Marshaller
     */
    private Marshaller createMarshaller(JAXBContext context) throws JAXBException {// String packageName) throws JAXBException {
        //final JAXBContext context = JAXBContext.newInstance(packageName);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
        m.setProperty(Marshaller.JAXB_ENCODING, ENGINE_CHAR_ENCODING);
        return m;
    }

    /**
     * Sets the host.
     * 
     * @param host the new host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Sets the port.
     * 
     * @param port the new port
     */
    public void setPort(int port) {
        this.port = port;
    }

}
