package com.pm.wordi.exception.user;

public class NoExistEmailException extends RuntimeException{
    public NoExistEmailException() {
        super();
    }

    public NoExistEmailException(String message) {
        super(message);
    }
}
