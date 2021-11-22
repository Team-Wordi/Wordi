package com.pm.wordi.exception.mentoring;

public class EqualUserMentorException extends RuntimeException{
    public EqualUserMentorException() {
        super();
    }

    public EqualUserMentorException(String message) {
        super(message);
    }
}
