package com.jfaas.domain.exception;

/**
 * @author : neason-cn
 * @date : 2021/10/29
 */
public class FaasRuntimeException extends RuntimeException {

    public FaasRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FaasRuntimeException(Throwable cause) {
        super(cause);
    }

    public FaasRuntimeException(String message) {
        super(message);
    }

}