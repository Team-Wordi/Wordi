package com.pm.wordi.exception.mentor;

public class NoExistMentoringProfileException extends RuntimeException{
    public NoExistMentoringProfileException() {
        super();
    }

    public NoExistMentoringProfileException(String message) {
        super(message);
    }
}
