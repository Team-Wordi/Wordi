package com.pm.wordi.exception.file;

public class CertificationFileSaveFailedException extends RuntimeException{
    public CertificationFileSaveFailedException() {
        super();
    }

    public CertificationFileSaveFailedException(String message) {
        super(message);
    }
}
