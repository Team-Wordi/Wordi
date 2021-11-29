package com.pm.wordi.controller;

import com.pm.wordi.controller.dto.CommonDto.MainRes;
import com.pm.wordi.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequiredArgsConstructor
public class CommonApiController {

    private final CommonService commonService;

    /**
     * 메인 페이지 API
     * [GET] /app
     * @return ResponseEntity<MainRes>
     */
    @GetMapping("/app")
    public ResponseEntity<MainRes> getMain(HttpServletRequest request) {
        Long userId = (Long)request.getAttribute("userId");
        return ResponseEntity.ok(commonService.getMain(userId));
    }
}
