package com.pm.wordi.controller;


import com.pm.wordi.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.pm.wordi.commons.utils.constants.ResponseConstants.*;
import static com.pm.wordi.controller.dto.MentorDto.*;

@RestController
@RequestMapping("/app/mentors")
@RequiredArgsConstructor
public class MentorApiController {

    private final MentorService mentorService;

    /**
     * 멘토등록 API
     * [POST] /app/mentors
     * @return BaseResponse<HttpStatus>
     */
    @PostMapping("")
    public ResponseEntity<HttpStatus> createMentor(@Validated @RequestBody CreateRequest createRequest,
                                                   HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        mentorService.createMentor(userId, createRequest);
        return RESPONSE_OK;
    }

    /**
     * 멘토 프로필 관리 조회 API
     * [GET] /app/mentors/profile
     * @return BaseResponse<ProfileRes>
     */
    @GetMapping("/profile")
    public ResponseEntity<ProfileRes> getProfile(HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        return ResponseEntity.ok(mentorService.getProfile(userId));
    }

    /**
     * 멘토 프로필 수정 API
     * [PATCH] /app/mentors/profile
     * @return BaseResponse<HttpStatus>
     */
    @PatchMapping("/profile")
    public ResponseEntity<HttpStatus> updateProfile(@Validated @RequestBody ProfileReq profileReq,
                                                    HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        mentorService.updateProfile(userId, profileReq);
        return RESPONSE_OK;
    }

}
