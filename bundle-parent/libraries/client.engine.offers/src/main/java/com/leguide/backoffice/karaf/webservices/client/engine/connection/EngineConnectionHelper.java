package com.leguide.backoffice.karaf.webservices.client.engine.connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The Class EngineConnectionHelper.
 * 
 * @author frederic.quinet
 */
public class EngineConnectionHelper {

    /** The host. */
    private String host;

    /** The port. */
    private int port;

    /** Logger for this class. */
    private static Logger logger = LoggerFactory.getLogger(EngineConnectionHelper.class);

    /**
     * Instantiates a new engine connection helper.
     */
    public EngineConnectionHelper(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * Gets the engine connection.
     * 
     * @return the engine connection
     */
    public EngineConnection getEngineConnection() {
        return new EngineConnection(host, port);
    }

    /**
     * Gets the engine connection.
     * 
     * @return the engine connection
     */
    public EngineConnection getEngineConnection(int readTimeout) {
        return new EngineConnection(host, port, readTimeout);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
