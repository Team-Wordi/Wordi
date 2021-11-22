package com.pm.wordi.service;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.*;
import com.pm.wordi.domain.user.User;
import com.pm.wordi.domain.user.UserRepository;
import com.pm.wordi.exception.mentor.ExistMentorException;
import com.pm.wordi.exception.mentor.NoExistMentorException;
import com.pm.wordi.exception.mentor.NoExistMentoringProfileException;
import com.pm.wordi.exception.user.NoExistUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.pm.wordi.controller.dto.MentorDto.*;
import static com.pm.wordi.domain.BaseStatus.*;

@Service
@RequiredArgsConstructor
@Transactional
public class MentorService {

    private final UserRepository userRepository;
    private final MentorRepository mentorRepository;
    private final MentorKeywordRepository mentorKeywordRepository;
    private final MentorScheduleRepository mentorScheduleRepository;

    @Transactional
    public void createMentor(Long userId, CreateRequest createRequest) {

        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보와 일치하는 회원 정보가 없습니다."));

        if(mentorRepository.countByUser(user)>=1) {
            throw new ExistMentorException("이미 가입하신 멘토 정보가 있습니다.");
        }

        Mentor mentor = mentorRepository.save(createRequest.toEntity(user));

        // 멘토 키워드 저장
        createRequest.getKeywordList().stream()
                .forEach(k -> mentorKeywordRepository.save(new MentorKeyword(mentor, k)));

        // 멘토 일정 저장
        createRequest.getScheduleList().stream()
                .forEach(s -> mentorScheduleRepository.save(s.toMentorSchedule(mentor)));
    }

    @Transactional(readOnly = true)
    public ProfileRes getProfile(Long userId) {
        return mentorRepository.findProfileByUserIdAndStatus(userId, ACTIVE)
                .map(ProfileRes::new)
                .orElseThrow(() -> new NoExistMentorException("해당 회원의 멘토 정보가 존재하지 않습니다."));

    }

    @Transactional
    public void updateProfile(Long userId, ProfileReq profileReq) {

        Mentor mentor = mentorRepository.findProfileByUserIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistMentorException("해당 회원의 멘토 정보가 존재하지 않습니다."));

        mentor.updateProfile(profileReq);

        // 키워드 업데이트
        mentorKeywordRepository.deleteByMentor(mentor);
        profileReq.getKeywordList().stream()
                .forEach(k -> mentorKeywordRepository.save(new MentorKeyword(mentor, k)));

        // 일정 업데이트
        mentorScheduleRepository.deleteByMentor(mentor);
        profileReq.getScheduleList().stream()
                .forEach(s -> mentorScheduleRepository.save(s.toMentorSchedule(mentor)));

    }

    @Transactional(readOnly = true)
    public List<ProfileListRes> searchProfileList() {
        return mentorRepository.searchProfileList().stream()
                .map(ProfileListRes::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MentoringProfileRes getMentoringProfile(Long mentorId) {
        return mentorRepository.findByIdAndStatus(mentorId, ACTIVE)
                .map(MentoringProfileRes::new)
                .orElseThrow(() -> new NoExistMentoringProfileException("해당 멘토 프로필이 존재하지 않습니다."));
    }
}
