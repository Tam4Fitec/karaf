package com.leguide.backoffice.karaf.webservices.wsbrands.api.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.brands.common.exception.NotFoundException;

@Component
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {

        WSExceptionOutput output = new WSExceptionOutput("NOT_FOUND_EXCEPTION", exception.getMessage());

        return Response.status(Status.NOT_FOUND.getStatusCode()).entity(output)
                .header("ERROR_TYPE", "NOT_FOUND_EXCEPTION").build();
    }

}
