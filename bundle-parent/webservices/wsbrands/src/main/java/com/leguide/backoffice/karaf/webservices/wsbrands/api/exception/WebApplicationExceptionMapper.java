package com.leguide.backoffice.karaf.webservices.wsbrands.api.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    private Logger logger = LoggerFactory.getLogger(WebApplicationExceptionMapper.class);

    @Override
    public Response toResponse(WebApplicationException exception) {

        this.logger.info(exception.getMessage(), exception);

        WSExceptionOutput output = new WSExceptionOutput("WEB_APPLICATION_EXCEPTION", exception.getMessage());

        return Response.status(exception.getResponse().getStatus()).entity(output)
                .header("ERROR_TYPE", exception.getResponse().getStatus()).build();
    }

}
