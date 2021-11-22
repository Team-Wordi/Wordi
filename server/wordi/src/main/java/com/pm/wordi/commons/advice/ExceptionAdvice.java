package com.pm.wordi.commons.advice;

import com.pm.wordi.exception.DecryptException;
import com.pm.wordi.exception.EncryptException;
import com.pm.wordi.exception.mentor.ExistMentorException;
import com.pm.wordi.exception.mentor.NoExistMentorException;
import com.pm.wordi.exception.mentor.NoExistMentoringProfileException;
import com.pm.wordi.exception.mentoring.EqualUserMentorException;
import com.pm.wordi.exception.user.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.pm.wordi.commons.utils.constants.ResponseConstants.BAD_JSON_GRAMMAR;
import static com.pm.wordi.commons.utils.constants.ResponseConstants.MULTIPLE_BAG_FETCH;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {


    // == User ==

    @ExceptionHandler(CertifiedException.class)
    public ResponseEntity<String> notAuthorizedException(CertifiedException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(EncryptException.class)
    public ResponseEntity<String> encryptException(EncryptException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DecryptException.class)
    public ResponseEntity<String> decryptException(DecryptException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoExistEmailException.class)
    public ResponseEntity<String> noExistEmailException(NoExistEmailException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NotMatchPasswordException.class)
    public ResponseEntity<String> notMatchPasswordException(NotMatchPasswordException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NoExistUserException.class)
    public ResponseEntity<String> noExistUserException(NoExistUserException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NotAuthorizedException.class)
    public ResponseEntity<String> notAuthorizedException(NotAuthorizedException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
    }


    // == Mentor ==

    @ExceptionHandler(NoExistMentorException.class)
    public ResponseEntity<String> noExistMentorException(NoExistMentorException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ExistMentorException.class)
    public ResponseEntity<String> existMentorException(ExistMentorException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoExistMentoringProfileException.class)
    public ResponseEntity<String> noExistMentoringProfileException(NoExistMentoringProfileException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    // == Mentoring
    @ExceptionHandler(EqualUserMentorException.class)
    public ResponseEntity<String> equalUserMentorException(EqualUserMentorException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }



    // == client ==

    // 검증 에러
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(e.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

    // 잘못된 JSON 문법 요청 에러
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        e.printStackTrace();
        return BAD_JSON_GRAMMAR;
    }


    // == Server ==

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>("등록되지 않은 에러입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // DB
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<String> invalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e) {
        e.printStackTrace();
        return MULTIPLE_BAG_FETCH;
    }



}
