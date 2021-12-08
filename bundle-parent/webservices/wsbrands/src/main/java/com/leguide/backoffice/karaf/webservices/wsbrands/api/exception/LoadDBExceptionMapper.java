package com.leguide.backoffice.karaf.webservices.wsbrands.api.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.brands.common.exception.LoadDBException;

@Component
@Provider
public class LoadDBExceptionMapper implements ExceptionMapper<LoadDBException> {

    @Override
    public Response toResponse(LoadDBException exception) {

        WSExceptionOutput output = new WSExceptionOutput("LOAD_DB_EXCEPTION", "LOAD_DB_EXCEPTION");

        return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(output)
                .header("ERROR_TYPE", "LOAD_DB_EXCEPTION").header("INTERNAL_ERROR_CODE", exception.getErr()).build();
    }

}
