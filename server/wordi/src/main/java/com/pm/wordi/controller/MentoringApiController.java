package com.pm.wordi.controller;


import com.pm.wordi.controller.dto.MentorDto;
import com.pm.wordi.controller.dto.MentoringDto;
import com.pm.wordi.service.MentoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.pm.wordi.commons.utils.constants.ResponseConstants.RESPONSE_CREATED;
import static com.pm.wordi.controller.dto.MentoringDto.*;

@RestController
@RequestMapping("/app/mentors/{mentorId}/applications")
@RequiredArgsConstructor
public class MentoringApiController {

    private final MentoringService mentoringService;

    /**
     * 멘토링 신청 API
     * [POST] /app/mentors/{mentorId}/applications
     * @return BaseResponse<HttpStatus>
     */
    @PostMapping("")
    public ResponseEntity<HttpStatus> createMentoring(@Validated @RequestBody CreateRequest createRequest,
                                                      @PathVariable Long mentorId,
                                                      HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        mentoringService.createMentoring(mentorId, userId, createRequest);
        return RESPONSE_CREATED;
    }

    /**
     * 멘토링 신청 페이지 API
     * [GET] /app/mentors/{mentorId}/applications
     * @return BaseResponse<MentoringRes>
     */
    @GetMapping("")
    public ResponseEntity<MentoringRes> getMentoring(@PathVariable Long mentorId,
                                                     HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        return ResponseEntity.ok(mentoringService.getMentoring(mentorId, userId));
    }

}
