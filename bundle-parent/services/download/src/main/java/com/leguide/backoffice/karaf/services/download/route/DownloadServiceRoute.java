package com.leguide.backoffice.karaf.services.download.route;

import static org.apache.camel.builder.PredicateBuilder.and;
import static org.apache.camel.builder.PredicateBuilder.or;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;

import com.leguide.backoffice.karaf.services.download.DownloadServiceConstants;

public class DownloadServiceRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        Predicate mandatoryParametersAreSet = and(
                header(DownloadServiceConstants.FUNCTIONAL_FILE_NAME).isNotNull(),
                header(DownloadServiceConstants.TECHNICAL_FILE_NAME).isNotNull(),
                header(DownloadServiceConstants.FILE_LOCATION).isNotNull());

        from("jetty:http://0.0.0.0:8189/download?matchOnUriPrefix=true")
                .routeId("downloadservice-download")
                .setHeader("technicalFileName", simple("${bean:downloadServiceBean.retrieveTechnicalFileName}"))
                .log(LoggingLevel.INFO, "[DownloadService] Download file ${headers.technicalFileName}")
                .to("direct:getExportCsvInRedis")
                .choice()
                .when(body().isNotNull())
                    .setHeader("contentType", body())
                    .beanRef("downloadServiceBean", "downloadFile")
                    .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("200"))
                    .setHeader(Exchange.CONTENT_TYPE, header("contentType"))
                .otherwise()
                    .setHeader(Exchange.HTTP_RESPONSE_CODE, constant("404"))
                    .setHeader(Exchange.CONTENT_TYPE, constant("text/plain; charset=utf-8"))
                    .setBody(constant("Lien expiré."))
                .end();


        // Mandatory parameters: fileLocation, technicalFileName, functionalFileName
        from("direct-vm:uploadFile")
                .routeId("downloadservice-upload")
                .log(LoggingLevel.INFO, "[DownloadService] Upload file ${headers.technicalFileName}")
                .delay(5000l)
                .to("direct:checkNonRequiredHeaders")
                .choice()
                .when(mandatoryParametersAreSet)
                	.log(LoggingLevel.WARN, "[DownloadService] Before prepareUpload")
                    .beanRef("downloadServiceBean", "prepareUpload")
                    .log(LoggingLevel.WARN, "[DownloadService] AFTER prepareUpload, BEFORE curl")
                    .to("exec:curl")
                    .log(LoggingLevel.WARN, "[DownloadService] AFTER curl")
                    .log(LoggingLevel.INFO, "[DownloadService] Upload file ${headers.technicalFileName} result : ${header.CamelExecExitValue}")
                    .to("direct:setExportCsvInRedis")
                    .beanRef("downloadServiceBean", "buildFileUrl")
                .otherwise()
                    .throwException(new IllegalArgumentException("[DownloadService] Error: parameters technicalFileName, fileLocation."))
                .end();

        from("direct:getExportCsvInRedis")
                .routeId("downloadservice-getExportCsvInRedis")
                .setHeader("CamelRedis.Command", constant("GET"))
                .setHeader("CamelRedis.Key", simple("download:${headers.technicalFileName}"))
                .to("spring-redis://?redisTemplate=#redisTemplateStringSerializer");

        from("direct:setExportCsvInRedis")
                .routeId("downloadservice-setExportCsvInRedis")
                .setHeader("CamelRedis.Command", constant("SETEX"))
                .setHeader("CamelRedis.Key", simple("download:${header.technicalFileName}"))
                .setHeader("CamelRedis.Value", header(DownloadServiceConstants.FILE_C0NTENT_TYPE))
                .setHeader("CamelRedis.Timeout", header(DownloadServiceConstants.EXPIRATION_TIME_DURATION))
                .to("spring-redis://?redisTemplate=#redisTemplateStringSerializer");

        from("direct:checkNonRequiredHeaders")
	    	.routeId("downloadservice-checkHeaders")
	    	.choice()
	    		.when(or(header(DownloadServiceConstants.FILE_C0NTENT_TYPE).isNull(), header(DownloadServiceConstants.FILE_C0NTENT_TYPE).isEqualTo("")))
                .setHeader(DownloadServiceConstants.FILE_C0NTENT_TYPE, constant("text/csv"))
	    	.endChoice()
                .choice()
                .when(header(DownloadServiceConstants.EXPIRATION_TIME_DURATION).isNull())
                .setHeader(DownloadServiceConstants.EXPIRATION_TIME_DURATION, constant(172800)) // 48H
	    	.endChoice()
	    .end();
    }
}
