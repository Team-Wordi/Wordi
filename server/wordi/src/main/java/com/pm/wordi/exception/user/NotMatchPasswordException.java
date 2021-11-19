package com.pm.wordi.exception.user;

public class NotMatchPasswordException extends RuntimeException{
    public NotMatchPasswordException() {
        super();
    }

    public NotMatchPasswordException(String message) {
        super(message);
    }
}
