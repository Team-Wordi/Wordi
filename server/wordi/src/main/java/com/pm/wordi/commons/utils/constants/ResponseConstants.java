package com.pm.wordi.commons.utils.constants;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseConstants {

    public static final ResponseEntity<HttpStatus> RESPONSE_OK = ResponseEntity.status(HttpStatus.OK).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_CREATED = ResponseEntity.status(HttpStatus.CREATED).build();


//    public static final ResponseEntity<String> DUPLICATION_EMAIL =
//            new ResponseEntity<>("중복된 이메일입니다.", HttpStatus.CONFLICT);
}
