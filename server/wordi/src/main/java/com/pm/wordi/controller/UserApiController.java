package com.pm.wordi.controller;

import com.pm.wordi.commons.annotation.UnAuth;
import com.pm.wordi.controller.dto.UserDto;
import com.pm.wordi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.pm.wordi.commons.utils.constants.ResponseConstants.RESPONSE_OK;
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
    public ResponseEntity<ResponseTokens> createUser(@Validated @RequestBody CreateRequest createRequest) {
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
     * @return BaseResponse<AccountRes>
     */
    @GetMapping("/account")
    public ResponseEntity<AccountRes> getAccount(HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        return ResponseEntity.ok(userService.getAccount(userId));
    }

    /**
     * 개인정보 수정 API
     * [PATCH] /app/users/account
     * @return BaseResponse<HttpStatus>
     */
    @PatchMapping("/account")
    public ResponseEntity<HttpStatus> updateAccount(@Validated @RequestBody AccountReq accountReq,
                                                    HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        userService.updateAccount(userId, accountReq);
        return RESPONSE_OK;
    }


    /**
     * 비밀번호 수정 API
     * [PATCH] /app/users/account/password
     * @return BaseResponse<HttpStatus>
     */
    @PatchMapping("/account/password")
    public ResponseEntity<HttpStatus> updatePassword(@Validated @RequestBody changePasswordReq changePasswordReq,
                                                    HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        userService.updatePassword(userId, changePasswordReq);
        return RESPONSE_OK;
    }

//    /**
//     * 프로필 조회 API
//     * [GET] /app/users/profile
//     * @return BaseResponse<HttpStatus>
//     */
//    @GetMapping("/profile")
//    public ResponseEntity<HttpStatus> getProfile(@Validated @RequestBody changePasswordReq changePasswordReq,
//                                                     HttpServletRequest request) {
//        Long userId = (Long)request.getAttribute("userId");
//        userService.updatePassword(userId, changePasswordReq);
//        return RESPONSE_OK;
//    }


}
