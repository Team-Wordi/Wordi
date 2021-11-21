package com.pm.wordi.controller;

import com.pm.wordi.commons.annotation.UnAuth;
import com.pm.wordi.commons.utils.constants.ResponseConstants;
import com.pm.wordi.controller.dto.MentorDto;
import com.pm.wordi.controller.dto.UserDto;
import com.pm.wordi.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.pm.wordi.commons.utils.constants.ResponseConstants.*;

@RestController
@RequestMapping("/app/mentors")
@RequiredArgsConstructor
public class MentorApiController {

    private final MentorService mentorService;

    /**
     * 멘토등록 API
     * [POST] /app/mentors
     * @return BaseResponse<ResponseTokens>
     */
    @PostMapping("")
    public ResponseEntity<HttpStatus> createMentor(@Validated @RequestBody MentorDto.CreateRequest createRequest,
                                                   HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        mentorService.createMentor(userId, createRequest);
        return RESPONSE_OK;
    }

}
