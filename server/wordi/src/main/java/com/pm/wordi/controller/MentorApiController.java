package com.pm.wordi.controller;


import com.pm.wordi.service.MentorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import java.util.List;

import static com.pm.wordi.commons.utils.constants.ResponseConstants.*;
import static com.pm.wordi.controller.dto.MentorDto.*;

@Slf4j
@RestController
@RequestMapping("/app/mentors")
@RequiredArgsConstructor
public class MentorApiController {

    private final MentorService mentorService;

    /**
     * 멘토등록 API
     * [POST] /app/mentors
     * @return ResponseEntity<HttpStatus>
     */
    @PostMapping("")
    public ResponseEntity<HttpStatus> createMentor(@Validated @RequestPart CreateRequest createRequest,
                                                   @RequestPart(required = false) MultipartFile profileImage,
                                                   @RequestPart(required = true) MultipartFile certification,
                                                   HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        mentorService.createMentor(userId, createRequest, profileImage, certification);
        return RESPONSE_CREATED;
    }

    /**
     * 멘토 프로필 관리 조회 API
     * [GET] /app/mentors/profile
     * @return ResponseEntity<ProfileRes>
     */
    @GetMapping("/profile")
    public ResponseEntity<ProfileRes> getProfile(HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        return ResponseEntity.ok(mentorService.getProfile(userId));
    }

    /**
     * 멘토 프로필 수정 API
     * [PATCH] /app/mentors/profile
     * @return ResponseEntity<HttpStatus>
     */
    @PatchMapping("/profile")
    public ResponseEntity<HttpStatus> updateProfile(@Validated @RequestBody ProfileReq profileReq,
                                                    HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        mentorService.updateProfile(userId, profileReq);
        return RESPONSE_OK;
    }

    /**
     * 멘토 프로필 리스트 API
     * [GET] /app/mentors?nation=&keyword=&months=
     * @return ResponseEntity<List<ProfileListRes>>
     */
    @GetMapping("")
    public ResponseEntity<List<ProfileListRes>> searchProfileList(@RequestParam(required = false) String nation,
                                                                  @RequestParam(required = false) String keyword,
                                                                  @RequestParam(required = false) Long months) {
        return ResponseEntity.ok(mentorService.searchProfileList(nation, keyword, months));
    }


    /**
     * 멘토 프로필 상세 조회 API
     * [GET] /app/mentors/{mentorId}
     * @return ResponseEntity<MentoringProfileRes>
     */
    @GetMapping("/{mentorId}")
    public ResponseEntity<MentoringProfileRes> getMentoringProfile(@PathVariable Long mentorId) {
        return ResponseEntity.ok(mentorService.getMentoringProfile(mentorId));
    }

    /**
     * 멘토 프로필 사진 수정 API
     * [PATCH] /app/mentors/profile/image
     * @return ResponseEntity<HttpStatus>
     */
    @PatchMapping("/profile/image")
    public ResponseEntity<HttpStatus> updateProfileImage(@RequestPart(required = false) MultipartFile profileImage,
                                                         HttpServletRequest request) {

        Long userId = (Long)request.getAttribute("userId");
        mentorService.updateProfileImage(userId, profileImage);
        return RESPONSE_OK;
    }

    /**
     * 멘토 ON, OFF API
     * [PATCH] /app/mentors?status=
     * @return ResponseEntity<HttpStatus>
     */
    @PatchMapping("")
    public ResponseEntity<HttpStatus> updateStatus(@RequestParam String status,
                                                   HttpServletRequest request) {

        Long userId = (Long)request.getAttribute("userId");
        mentorService.updateStatus(userId, status);
        return RESPONSE_OK;
    }


}
