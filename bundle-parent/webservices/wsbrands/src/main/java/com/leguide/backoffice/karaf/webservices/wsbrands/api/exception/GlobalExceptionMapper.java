package com.leguide.backoffice.karaf.webservices.wsbrands.api.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionMapper.class);

    @Override
    public Response toResponse(Exception exception) {

        this.logger.info(exception.getMessage(), exception);

        WSExceptionOutput output = new WSExceptionOutput("EXCEPTION", exception.getMessage());

        return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(output)
                .header("ERROR_TYPE", "EXCEPTION").build();
    }

}
