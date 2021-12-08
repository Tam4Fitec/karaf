package com.leguide.backoffice.karaf.webservices.wsbrands.api.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.brands.common.exception.BadRequestException;

@Component
@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException exception) {

        WSExceptionOutput output = new WSExceptionOutput("BAD_REQUEST_EXCEPTION", exception.getMessage());

        return Response.status(Status.BAD_REQUEST.getStatusCode()).entity(output)
                .header("ERROR_TYPE", "BAD_REQUEST_EXCEPTION").header("INTERNAL_ERROR_CODE", exception.getErrcode()).build();
    }

}
