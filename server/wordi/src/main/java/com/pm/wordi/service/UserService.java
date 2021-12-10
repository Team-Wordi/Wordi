package com.pm.wordi.service;

import com.pm.wordi.commons.utils.certification.AES128;
import com.pm.wordi.commons.utils.certification.Secret;
import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.mentor.repository.MentorRepository;
import com.pm.wordi.domain.mentoring.repository.MentoringRepository;
import com.pm.wordi.domain.user.entity.User;
import com.pm.wordi.domain.user.entity.UserKeyword;
import com.pm.wordi.domain.user.repository.UserKeywordRepository;
import com.pm.wordi.domain.user.repository.UserRepository;
import com.pm.wordi.exception.mentor.ExistNotFinishMentoringByMentorException;
import com.pm.wordi.exception.mentor.NoExistMentorException;
import com.pm.wordi.exception.user.ExistNotFinishMentoringByUserException;
import com.pm.wordi.exception.user.NoExistEmailException;
import com.pm.wordi.exception.user.NoExistUserException;
import com.pm.wordi.exception.user.NotMatchPasswordException;
import com.pm.wordi.service.certification.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.pm.wordi.controller.dto.UserDto.*;
import static com.pm.wordi.domain.BaseStatus.*;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final UserKeywordRepository userKeywordRepository;
    private final MentorRepository mentorRepository;
    private final MentoringRepository mentoringRepository;

    @Transactional
    public ResponseTokens save(CreateRequest createRequest) {

        createRequest.passwordEncryption();

        // 유저 저장
        User user = userRepository.save(createRequest.toEntity());

        // 키워드 저장
        createRequest.getUserKeywordList()
                .stream().forEach(k -> userKeywordRepository.save(new UserKeyword(user, k)));


        String jwt = jwtService.createJwt(user.getId());
        return new ResponseTokens(user.getId(), jwt);
    }

    @Transactional(readOnly = true)
    public ResponseTokens login(LoginReq loginReq) {
        User user = userRepository.findByEmailAndStatus(loginReq.getEmail(), ACTIVE)
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
        return userRepository.existsByEmailAndStatus(email, ACTIVE);
    }

    @Transactional(readOnly = true)
    public boolean checkNicknameDuplicate(String nickname) {
        return userRepository.existsByNicknameAndStatus(nickname, ACTIVE);
    }

    @Transactional(readOnly = true)
    public AccountRes getAccount(Long userId) {
        return userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(()->new NoExistUserException("접속한 회원 정보와 일치하는 회원 정보가 없습니다.")).toAccountRes();
    }

    @Transactional
    public void updateAccount(Long userId, AccountReq accountReq) {
        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보와 일치하는 회원 정보가 없습니다."));

        user.updateAccount(
                accountReq.getEmail(),
                accountReq.getPhoneNumber());
    }

    @Transactional
    public void updatePassword(Long userId, changePasswordReq changePasswordReq) {

        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보와 일치하는 회원 정보가 없습니다."));

        changePasswordReq.passwordEncryption();
        String beforePassword = changePasswordReq.getBeforePassword();
        String afterPassword = changePasswordReq.getAfterPassword();

        if(!user.getPassword().equals(beforePassword)) {
            throw new NotMatchPasswordException("현재 비밀번호와 일치하지 않습니다.");
        }

        user.updatePassword(afterPassword);

    }

    @Transactional(readOnly = true)
    public ProfileRes getProfile(Long userId) {
        return userRepository.findFetchByIdAndStatus(userId, ACTIVE)
                .map(ProfileRes::new)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보와 일치하는 회원 정보가 없습니다."));
    }

    @Transactional
    public void updateProfile(Long userId, ProfileReq profileReq) {
        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보와 일치하는 회원 정보가 없습니다."));

        user.updateProfile(profileReq);

        //키워드 업데이트
        userKeywordRepository.deleteByUser(user);
        profileReq.getUserKeywordList()
                .stream().forEach(k -> userKeywordRepository.save(new UserKeyword(user, k)));

    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보와 일치하는 회원 정보가 없습니다."));

        if(mentorRepository.findByUserIdAndStatus(user.getId(), ACTIVE).isPresent()) {
            Mentor mentor = mentorRepository.findByUserIdAndStatus(user.getId(), ACTIVE)
                    .orElseThrow(() -> new NoExistMentorException("접속한 회원 정보와 일치하는 멘토 정보가 없습니다."));

            if(!mentoringRepository.findAllToCheckMentorOff(mentor).isEmpty()) {
                throw new ExistNotFinishMentoringByMentorException("아직 처리하지 않은 멘토 멘토링 서비스가 남아있습니다.");
            }

            mentor.updateDeleteStatus();
        }

        if(!mentoringRepository.findAllToCheckUserDelete(user).isEmpty()) {
            throw new ExistNotFinishMentoringByUserException("아직 처리하지 않은 유저 멘토링 서비스가 남아있습니다.");
        }

        user.updateDeleteStatus();
    }
}
