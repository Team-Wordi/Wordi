package com.pm.wordi.controller;

import com.pm.wordi.controller.dto.UserDto;
import com.pm.wordi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pm.wordi.controller.dto.UserDto.*;


@RestController
@RequestMapping("/app/users")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/account/signup")
    public ResponseEntity<ResponseTokens> createUser(@RequestBody CreateRequest createRequest) {

        ResponseTokens responseTokens = userService.save(createRequest);
        return ResponseEntity.ok(responseTokens);

    }
}
