package com.pm.wordi.exception.file;

public class IllegalMimeTypeException extends RuntimeException{
    public IllegalMimeTypeException() {
        super();
    }

    public IllegalMimeTypeException(String message) {
        super(message);
    }
}
