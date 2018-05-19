package com.github.dobrovolskiy.controller;

import com.github.dobrovolskiy.exception.BusinessException;
import com.github.dobrovolskiy.model.Error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.status;

/**
 * Handler for the {@link BusinessException}
 *
 * @see BusinessException
 * @since 1.0
 */
@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {
    @Override
    public Response toResponse(BusinessException e) {
        return status(INTERNAL_SERVER_ERROR)
                .entity(new Error(INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()))
                .type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
