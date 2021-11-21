package com.pm.wordi.exception.mentor;

public class NoExistMentorException extends RuntimeException{
    public NoExistMentorException() {
        super();
    }

    public NoExistMentorException(String message) {
        super(message);
    }
}
