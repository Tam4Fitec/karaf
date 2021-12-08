package com.leguide.backoffice.karaf.services.download.beans;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.leguide.backoffice.karaf.services.download.DownloadServiceConstants;

public class DownloadServiceBean {

    @Value("${download.ftp.host}")
    private String ftpHost;

    @Value("${download.ftp.port}")
    private String ftpPort;

    @Value("${download.ftp.user}")
    private String ftpUser;

    @Value("${download.ftp.password}")
    private String ftpPassword;

    @Value("${download.ftp.path}")
    private String ftpPath;

    @Value("${download.server}")
    private String downloadServer;
    
    private Logger logger = LoggerFactory.getLogger(DownloadServiceBean.class);

    public String retrieveTechnicalFileName(@Header("CamelHttpPath") String camelHttpPath) {
        return camelHttpPath.split("/")[1];
    }

    public File downloadFile(@Header("technicalFileName") String technicalFileName, @Body String functionalFileName) throws IOException {
        URL url = new URL("ftp://" + ftpUser + ":" + ftpPassword + "@" + ftpHost + ftpPath + technicalFileName);
        File file = new File(functionalFileName);
        
        logger.warn("[DownloadServiceBean] downloadFile method | url : " + url);
        logger.warn("[DownloadServiceBean] downloadFile method | technicalFileName : " + technicalFileName);
        logger.warn("[DownloadServiceBean] downloadFile method | functionalFileName : " + functionalFileName);
        
        FileUtils.copyURLToFile(url, file);
        return file;
    }

    public void prepareUpload(Exchange e) {
    	logger.warn("[DownloadServiceBean] downloadFile method | INSIDE");
        String fileLocation = e.getIn().getHeader(DownloadServiceConstants.FILE_LOCATION, String.class);
        String fileName = e.getIn().getHeader(DownloadServiceConstants.TECHNICAL_FILE_NAME, String.class);
        e.getIn().setHeader("CamelExecCommandWorkingDir", fileLocation);
        e.getIn().setHeader("CamelExecCommandArgs", "-T " + fileName + " ftp://" + ftpHost + ftpPath + " --user " + ftpUser + ":" + ftpPassword);
        logger.warn("[DownloadServiceBean] downloadFile method | fileName : " + fileName);
        logger.warn("[DownloadServiceBean] downloadFile method | CamelExecCommandWorkingDir fileLocation : " + fileLocation);
        logger.warn("[DownloadServiceBean] downloadFile method | CamelExecCommandArgs : " + "-T " + fileName + " ftp://" + ftpHost + ftpPath + " --user " + ftpUser + ":" + ftpPassword);
        
    }

    public String buildFileUrl(@Header("technicalFileName") String technicalFileName, @Header("functionalFileName") String functionalFileName) {
        return downloadServer + "/download/" + technicalFileName + "/" + functionalFileName;
    }
}
