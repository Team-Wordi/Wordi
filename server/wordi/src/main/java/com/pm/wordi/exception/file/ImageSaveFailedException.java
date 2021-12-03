package com.pm.wordi.exception.file;

public class ImageSaveFailedException extends RuntimeException{
    public ImageSaveFailedException() {
        super();
    }

    public ImageSaveFailedException(String message) {
        super(message);
    }
}
