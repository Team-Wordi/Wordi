package com.pm.wordi.exception.mentoring;

public class NoExistMentoringException extends RuntimeException{
    public NoExistMentoringException() {
        super();
    }

    public NoExistMentoringException(String message) {
        super(message);
    }
}
