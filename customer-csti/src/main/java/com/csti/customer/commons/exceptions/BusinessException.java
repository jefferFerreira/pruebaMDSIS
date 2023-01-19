package com.csti.customer.commons.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class BusinessException extends Exception implements Serializable {

    @Serial
    private static final long serialVersionUID = 6554876602662542894L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}