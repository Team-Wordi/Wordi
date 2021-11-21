package com.pm.wordi.commons.utils.constants;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseConstants {

    public static final ResponseEntity<HttpStatus> RESPONSE_OK = ResponseEntity.status(HttpStatus.OK).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_CREATED = ResponseEntity.status(HttpStatus.CREATED).build();


    public static final ResponseEntity<String> MULTIPLE_BAG_FETCH =
            new ResponseEntity<>("DB 에러입니다. MULTIPLE_BAG_FETCH.", HttpStatus.INTERNAL_SERVER_ERROR);

    public static final ResponseEntity<String> BAD_JSON_GRAMMAR =
            new ResponseEntity<>("JSON 문법 오류입니다. 잘못된 요청값 또는 타입 입력. ", HttpStatus.BAD_REQUEST);

}
