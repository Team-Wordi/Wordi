package com.pm.wordi.service.certification;

import com.pm.wordi.domain.user.User;
import com.pm.wordi.domain.user.UserRepository;
import com.pm.wordi.exception.user.NoExistUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SessionLoginService {

    private final UserRepository userRepository;


    public boolean checkAuth(Long userId, String auth) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoExistUserException("로그인 정보와 일치하는 회원 정보가 없습니다."));

        return user.getUserLevel().equals(auth);


    }
}
