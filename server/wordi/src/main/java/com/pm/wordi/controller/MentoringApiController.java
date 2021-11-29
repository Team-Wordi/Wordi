package com.pm.wordi.controller;


import com.pm.wordi.service.MentoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.pm.wordi.commons.utils.constants.ResponseConstants.RESPONSE_CREATED;
import static com.pm.wordi.commons.utils.constants.ResponseConstants.RESPONSE_OK;
import static com.pm.wordi.controller.dto.MentoringDto.*;

@RestController
@RequiredArgsConstructor
public class MentoringApiController {

    private final MentoringService mentoringService;

    /**
     * 멘토링 신청 API
     * [POST] /app/mentors/{mentorId}/applications
     * @return ResponseEntity<HttpStatus>
     */
    @PostMapping("/app/mentors/{mentorId}/applications")
    public ResponseEntity<HttpStatus> createMentoring(@Validated @RequestBody ApplicationReq applicationReq,
                                                      @PathVariable Long mentorId,
                                                      HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        mentoringService.createMentoring(mentorId, userId, applicationReq);
        return RESPONSE_CREATED;
    }

    /**
     * 멘토링 신청 페이지 API
     * [GET] /app/mentors/{mentorId}/applications
     * @return ResponseEntity<MentoringRes>
     */
    @GetMapping("/app/mentors/{mentorId}/applications")
    public ResponseEntity<ApplicationRes> getMentoring(@PathVariable Long mentorId,
                                                       HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        return ResponseEntity.ok(mentoringService.getMentoring(mentorId, userId));
    }

    /**
     * 멘토 - 멘토링 내역 조회 API
     * [GET] /app/mentors/mentorings
     * @return ResponseEntity<List<MentorMentoringRes>>
     */
    @GetMapping("/app/mentors/mentorings")
    public ResponseEntity<List<MentorMentoringRes>> geMentoringListBytMentor(HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        return ResponseEntity.ok(mentoringService.geMentoringListBytMentor(userId));
    }

    /**
     * 유저 - 멘토링 내역 조회 API
     * [GET] /app/users/mentorings
     * @return ResponseEntity<List<UserMentoringRes>>
     */
    @GetMapping("/app/users/mentorings")
    public ResponseEntity<List<UserMentoringRes>> geMentoringListByUser(HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        return ResponseEntity.ok(mentoringService.geMentoringListByUser(userId));
    }

    /**
     * 멘토 - 멘토링 신청 승인, 거절 API
     * [PATCH] /app/mentors/mentorings/{mentoringId}
     * @return ResponseEntity<RefundPaymentInfo>
     */
    @PatchMapping("/app/mentors/mentorings/{mentoringId}")
    public ResponseEntity<RefundPaymentInfo> decideMentoring(@RequestBody DecideReq decideReq,
                                                      @PathVariable Long mentoringId) {
        return ResponseEntity.ok(mentoringService.decideMentoring(mentoringId, decideReq));
    }

    /**
     * 유저 - 멘토링 취소 API
     * [GET] /app/users/mentorings/{mentoringId}
     * @return ResponseEntity<RefundPaymentInfo>
     */
    @GetMapping("/app/users/mentorings/{mentoringId}")
    public ResponseEntity<RefundPaymentInfo> cancelMentoring(@PathVariable Long mentoringId) {
        return ResponseEntity.ok(mentoringService.cancelMentoring(mentoringId));
    }



}
