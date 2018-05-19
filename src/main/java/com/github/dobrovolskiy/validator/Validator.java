package com.github.dobrovolskiy.validator;


import com.github.dobrovolskiy.exception.BusinessException;

/**
 * generic validator
 */
public interface Validator<T> {
    void validate(T toValidate) throws BusinessException;
}
