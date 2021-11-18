package com.pm.wordi.service;

import com.pm.wordi.domain.user.User;
import com.pm.wordi.domain.user.UserRepository;
import com.pm.wordi.service.certification.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.pm.wordi.controller.dto.UserDto.*;

@Service
@RequiredArgsConstructor
@Transactional // 차후에 readonly 조건 부여
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public ResponseTokens save(CreateRequest createRequest) {
        User user = userRepository.save(createRequest.toEntity());
        String jwt = jwtService.createJwt(user.getId());
        return new ResponseTokens(user.getId(), jwt);
    }

}
