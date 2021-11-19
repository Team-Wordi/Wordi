package com.pm.wordi.controller;

import com.pm.wordi.controller.dto.UserDto;
import com.pm.wordi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pm.wordi.controller.dto.UserDto.*;


@RestController
@RequestMapping("/app/users")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    /**
     * 회원가입 API
     * [POST] /app/users/account/signup
     * @return BaseResponse<ResponseTokens>
     */
    @PostMapping("/account/signup")
    public ResponseEntity<ResponseTokens> createUser(@RequestBody CreateRequest createRequest) {

        ResponseTokens responseTokens = userService.save(createRequest);
        return ResponseEntity.ok(responseTokens);

    }

    /**
     * 로그인 API
     * [POST] /app/users/account/login
     * @return BaseResponse<ResponseTokens>
     */
    @PostMapping("/account/login")
    public ResponseEntity<ResponseTokens> login(@RequestBody LoginReq loginReq) {

        ResponseTokens responseTokens = userService.login(loginReq);
        return ResponseEntity.ok(responseTokens);

    }


}
