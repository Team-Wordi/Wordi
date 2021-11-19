package com.pm.wordi.service;

import com.pm.wordi.commons.utils.certification.AES128;
import com.pm.wordi.commons.utils.certification.Secret;
import com.pm.wordi.domain.user.User;
import com.pm.wordi.domain.user.UserRepository;
import com.pm.wordi.exception.user.NoExistEmailException;
import com.pm.wordi.exception.user.NotMatchPasswordException;
import com.pm.wordi.service.certification.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.pm.wordi.controller.dto.UserDto.*;

@Service
@RequiredArgsConstructor
@Transactional // 차후에 readonly 조건 부여
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public ResponseTokens save(CreateRequest createRequest) {

        createRequest.passwordEncryption();

        User user = userRepository.save(createRequest.toEntity());
        String jwt = jwtService.createJwt(user.getId());
        return new ResponseTokens(user.getId(), jwt);
    }

    public ResponseTokens login(LoginReq loginReq) {
        User user = userRepository.findByEmail(loginReq.getEmail())
                .orElseThrow(() -> new NoExistEmailException("이메일과 일치하는 회원이 없습니다."));

        String password = new AES128(Secret.USER_INFO_PASSWORD_KEY).decrypt(user.getPassword());
        if(!password.equals(loginReq.getPassword())) {
            throw new NotMatchPasswordException("비밀번호가 일치하지 않습니다.");
        }

        Long id = user.getId();
        String jwt = jwtService.createJwt(user.getId());

        return new ResponseTokens(id, jwt);
    }
}
