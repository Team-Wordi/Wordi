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
     * @return ResponseEntity<ResponseTokens>
     */
    @UnAuth
    @PostMapping("/account/signup")
    public ResponseEntity<ResponseTokens> createUser(@Validated @RequestBody CreateRequest createRequest) {
        return ResponseEntity.ok(userService.save(createRequest));
    }

    /**
     * 로그인 API
     * [POST] /app/users/account/login
     * @return ResponseEntity<ResponseTokens>
     */
    @UnAuth
    @PostMapping("/account/login")
    public ResponseEntity<ResponseTokens> login(@RequestBody LoginReq loginReq) {
        return ResponseEntity.ok(userService.login(loginReq));
    }

    /**
     * 이메일 중복체크 API
     * [GET] /app/users/account/check-duplicate/{email}
     * @return ResponseEntity<Boolean>
     */
    @UnAuth
    @GetMapping("/account/check-duplicate/{email}")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email) {
        return ResponseEntity.ok(userService.checkEmailDuplicate(email));

    }

    /**
     * 닉네임 중복체크 API
     * [GET] /app/users/profile/check-duplicate/{nickname}
     * @return ResponseEntity<Boolean>
     */
    @UnAuth
    @GetMapping("/profile/check-duplicate/{nickname}")
    public ResponseEntity<Boolean> checkNicknameDuplicate(@PathVariable String nickname) {
        return ResponseEntity.ok(userService.checkNicknameDuplicate(nickname));

    }

    /**
     * 개인정보 조회 API
     * [GET] /app/users/account
     * @return ResponseEntity<AccountRes>
     */
    @GetMapping("/account")
    public ResponseEntity<AccountRes> getAccount(HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        return ResponseEntity.ok(userService.getAccount(userId));
    }

    /**
     * 개인정보 수정 API
     * [PATCH] /app/users/account
     * @return ResponseEntity<HttpStatus>
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
     * @return ResponseEntity<HttpStatus>
     */
    @PatchMapping("/account/password")
    public ResponseEntity<HttpStatus> updatePassword(@Validated @RequestBody changePasswordReq changePasswordReq,
                                                    HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        userService.updatePassword(userId, changePasswordReq);
        return RESPONSE_OK;
    }

    /**
     * 프로필 조회 API
     * [GET] /app/users/profile
     * @return ResponseEntity<ProfileRes>
     */
    @GetMapping("/profile")
    public ResponseEntity<ProfileRes> getProfile(HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        return ResponseEntity.ok(userService.getProfile(userId));
    }

    /**
     * 프로필 수정 API
     * [PATCH] /app/users/profile
     * @return ResponseEntity<HttpStatus>
     */
    @PatchMapping("/profile")
    public ResponseEntity<HttpStatus> updateProfile(@Validated @RequestBody ProfileReq profileReq,
                                                    HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        userService.updateProfile(userId, profileReq);
        return RESPONSE_OK;
    }

    /**
     * 회원탈퇴 API
     * [DELETE] /app/users/account
     * @return ResponseEntity<HttpStatus>
     */
    @DeleteMapping("/account")
    public ResponseEntity<HttpStatus> deleteUser(HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        userService.deleteUser(userId);
        return RESPONSE_OK;
    }



}
