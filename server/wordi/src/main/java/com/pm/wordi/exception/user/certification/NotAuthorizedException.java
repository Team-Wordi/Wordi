package com.pm.wordi.exception.user.certification;

public class NotAuthorizedException extends RuntimeException{
    public NotAuthorizedException() {
        super();
    }

    public NotAuthorizedException(String message) {
        super(message);
    }
}
