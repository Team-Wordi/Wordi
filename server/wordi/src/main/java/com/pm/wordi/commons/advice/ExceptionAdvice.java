package com.pm.wordi.commons.advice;

import com.pm.wordi.exception.DecryptException;
import com.pm.wordi.exception.EncryptException;
import com.pm.wordi.exception.user.certification.NotAuthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NotAuthorizedException.class)
    public ResponseEntity<String> notAuthorizedException(NotAuthorizedException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(EncryptException.class)
    public ResponseEntity<String> encryptException(EncryptException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DecryptException.class)
    public ResponseEntity<String> encryptException(DecryptException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
