package com.pm.wordi.service;

import com.pm.wordi.controller.dto.MentorDto;
import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.*;
import com.pm.wordi.domain.user.User;
import com.pm.wordi.domain.user.UserRepository;
import com.pm.wordi.exception.user.NoExistUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.pm.wordi.domain.BaseStatus.*;

@Service
@RequiredArgsConstructor
@Transactional
public class MentorService {

    private final UserRepository userRepository;
    private final MentorRepository mentorRepository;
    private final MentorKeywordRepository mentorKeywordRepository;
    private final MentorScheduleRepository mentorScheduleRepository;

    public void createMentor(Long userId, MentorDto.CreateRequest createRequest) {

        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보와 일치하는 회원 정보가 없습니다."));

        Mentor mentor = mentorRepository.save(createRequest.toEntity(user));

        // 멘토 키워드 저장
        createRequest.getKeywordList().stream()
                .forEach(k -> mentorKeywordRepository.save(new MentorKeyword(mentor, k)));

        // 멘토 일정 저장
        createRequest.getScheduleList().stream()
                .forEach(s -> mentorScheduleRepository.save(s.toMentorSchedule(mentor)));
    }
}
