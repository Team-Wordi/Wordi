package com.pm.wordi.service;

import com.pm.wordi.commons.utils.certification.AES128;
import com.pm.wordi.commons.utils.certification.Secret;
import com.pm.wordi.domain.user.*;
import com.pm.wordi.exception.user.NoExistEmailException;
import com.pm.wordi.exception.user.NoExistUserException;
import com.pm.wordi.exception.user.NotMatchPasswordException;
import com.pm.wordi.service.certification.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.pm.wordi.controller.dto.UserDto.*;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final UserKeywordRepository userKeywordRepository;


    @Transactional
    public ResponseTokens save(CreateRequest createRequest) {

        createRequest.passwordEncryption();

        // 유저 저장
        User user = userRepository.save(createRequest.toEntity());

        // 키워드 저장
        createRequest.getKeywordList()
                .stream().forEach(k -> userKeywordRepository.save(new UserKeyword(user, k)));


        String jwt = jwtService.createJwt(user.getId());
        return new ResponseTokens(user.getId(), jwt);
    }

    @Transactional(readOnly = true)
    public ResponseTokens login(LoginReq loginReq) {
        User user = userRepository.findByEmail(loginReq.getEmail())
                .orElseThrow(() -> new NoExistEmailException("이메일을 확인해주세요."));

        String password = new AES128(Secret.USER_INFO_PASSWORD_KEY).decrypt(user.getPassword());
        if(!password.equals(loginReq.getPassword())) {
            throw new NotMatchPasswordException("비밀번호가 일치하지 않습니다.");
        }

        Long id = user.getId();
        String jwt = jwtService.createJwt(user.getId());

        return new ResponseTokens(id, jwt);
    }

    @Transactional(readOnly = true)
    public boolean checkEmailDuplicate(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public boolean checkNicknameDuplicate(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    @Transactional(readOnly = true)
    public AccountRes getAccount(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new NoExistUserException("접속한 회원 정보아 일치하는 회원 정보가 없습니다.")).toAccountRes();
    }

    @Transactional
    public void updateAccount(Long userId, AccountReq accountReq) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보아 일치하는 회원 정보가 없습니다."));

        user.updateAccount(
                accountReq.getEmail(),
                accountReq.getPhoneNumber());
    }

    @Transactional
    public void updatePassword(Long userId, changePasswordReq changePasswordReq) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보아 일치하는 회원 정보가 없습니다."));

        changePasswordReq.passwordEncryption();
        String beforePassword = changePasswordReq.getBeforePassword();
        String afterPassword = changePasswordReq.getAfterPassword();

        if(!user.getPassword().equals(beforePassword)) {
            throw new NotMatchPasswordException("현재 비밀번호와 일치하지 않습니다.");
        }

        user.updatePassword(afterPassword);

    }
}
