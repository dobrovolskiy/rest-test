package com.github.dobrovolskiy.exception;

import javax.ws.rs.ext.Provider;

/**
 * Exception for business logic runtime errors
 *
 * @since 1.0
 */
@Provider
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }


}
