package com.pm.wordi.exception.mentor;

public class ExistMentorException extends RuntimeException{
    public ExistMentorException() {
        super();
    }

    public ExistMentorException(String message) {
        super(message);
    }
}
