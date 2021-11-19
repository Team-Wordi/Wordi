package com.pm.wordi.controller;

import com.pm.wordi.controller.dto.UserDto;
import com.pm.wordi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(userService.save(createRequest));
    }

    /**
     * 로그인 API
     * [POST] /app/users/account/login
     * @return BaseResponse<ResponseTokens>
     */
    @PostMapping("/account/login")
    public ResponseEntity<ResponseTokens> login(@RequestBody LoginReq loginReq) {
        return ResponseEntity.ok(userService.login(loginReq));
    }

    /**
     * 이메일 중복체크 API
     * [GET] /app/users/account/check-duplicate/{email}
     * @return BaseResponse<Boolean>
     */
    @GetMapping("/account/check-duplicate/{email}")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email) {
        return ResponseEntity.ok(userService.checkEmailDuplicate(email));

    }


}
