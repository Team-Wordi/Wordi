package com.pm.wordi.exception.file;

public class FileRoadFailedException extends RuntimeException{
    public FileRoadFailedException() {
        super();
    }

    public FileRoadFailedException(String message) {
        super(message);
    }
}
