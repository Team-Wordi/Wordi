package com.pm.wordi.exception.review;

public class NoExistReviewException extends RuntimeException{
    public NoExistReviewException() {
        super();
    }

    public NoExistReviewException(String message) {
        super(message);
    }
}
