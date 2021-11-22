package com.pm.wordi.exception.mentoring;

public class NoExistPaymentException extends RuntimeException{
    public NoExistPaymentException() {
        super();
    }

    public NoExistPaymentException(String message) {
        super(message);
    }
}
