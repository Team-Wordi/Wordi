package com.pm.wordi.controller;

import com.pm.wordi.controller.dto.ReviewDto;
import com.pm.wordi.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.pm.wordi.commons.utils.constants.ResponseConstants.RESPONSE_CREATED;
import static com.pm.wordi.controller.dto.ReviewDto.*;

@RestController
@RequestMapping("/app/reviews")
@RequiredArgsConstructor
public class ReviewApiController {

    private final ReviewService reviewService;

    /**
     * 리뷰 등록 API
     * [POST] /app/reviews
     * @return ResponseEntity<HttpStatus>
     */
    @PostMapping("")
    public ResponseEntity<HttpStatus> createReview(@RequestBody CreateRequest createRequest,
                                                   HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        reviewService.createReview(userId, createRequest);
        return RESPONSE_CREATED;
    }



}
