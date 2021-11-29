package com.pm.wordi.exception.review;

public class NoMatchUserReviewException extends RuntimeException{
    public NoMatchUserReviewException() {
        super();
    }

    public NoMatchUserReviewException(String message) {
        super(message);
    }
}
