package com.pm.wordi.controller;

import com.pm.wordi.commons.annotation.UnAuth;
import com.pm.wordi.controller.dto.UserDto;
import com.pm.wordi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    @UnAuth
    @PostMapping("/account/signup")
    public ResponseEntity<ResponseTokens> createUser(@RequestBody CreateRequest createRequest) {
        return ResponseEntity.ok(userService.save(createRequest));
    }

    /**
     * 로그인 API
     * [POST] /app/users/account/login
     * @return BaseResponse<ResponseTokens>
     */
    @UnAuth
    @PostMapping("/account/login")
    public ResponseEntity<ResponseTokens> login(@RequestBody LoginReq loginReq) {
        return ResponseEntity.ok(userService.login(loginReq));
    }

    /**
     * 이메일 중복체크 API
     * [GET] /app/users/account/check-duplicate/{email}
     * @return BaseResponse<Boolean>
     */
    @UnAuth
    @GetMapping("/account/check-duplicate/{email}")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email) {
        return ResponseEntity.ok(userService.checkEmailDuplicate(email));

    }

    /**
     * 닉네임 중복체크 API
     * [GET] /app/users/profile/check-duplicate/{nickname}
     * @return BaseResponse<Boolean>
     */
    @UnAuth
    @GetMapping("/profile/check-duplicate/{nickname}")
    public ResponseEntity<Boolean> checkNicknameDuplicate(@PathVariable String nickname) {
        return ResponseEntity.ok(userService.checkNicknameDuplicate(nickname));

    }

    /**
     * 개인정보 조회 API
     * [GET] /app/users/account
     * @return BaseResponse<Boolean>
     */
    @GetMapping("/account")
    public ResponseEntity<AccountRes> getAccount(HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        return ResponseEntity.ok(userService.getAccount(userId));
    }


}
