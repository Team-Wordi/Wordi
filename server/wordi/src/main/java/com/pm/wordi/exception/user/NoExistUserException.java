package com.pm.wordi.exception.user;

public class NoExistUserException extends RuntimeException{
    public NoExistUserException() {
        super();
    }

    public NoExistUserException(String message) {
        super(message);
    }
}
