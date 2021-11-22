package com.pm.wordi.service;

import com.pm.wordi.controller.dto.MentoringDto;
import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.Mentor;
import com.pm.wordi.domain.mentor.MentorRepository;
import com.pm.wordi.domain.mentoring.MentoringRepository;
import com.pm.wordi.domain.mentoring.Payment;
import com.pm.wordi.domain.mentoring.PaymentRepository;
import com.pm.wordi.domain.user.User;
import com.pm.wordi.domain.user.UserRepository;
import com.pm.wordi.exception.mentor.NoExistMentoringProfileException;
import com.pm.wordi.exception.mentoring.EqualUserMentorException;
import com.pm.wordi.exception.user.NoExistUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.pm.wordi.controller.dto.MentoringDto.*;
import static com.pm.wordi.domain.BaseStatus.*;

@Service
@RequiredArgsConstructor
@Transactional
public class MentoringService {

    private final UserRepository userRepository;
    private final MentorRepository mentorRepository;
    private final MentoringRepository mentoringRepository;
    private final PaymentRepository paymentRepository;

    @Transactional
    public void createMentoring(Long mentorId, Long userId, CreateRequest createRequest) {

        // 유저, 멘토 정보 조회
        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속하신 회원 정보가 존재하지 않습니다."));
        Mentor mentor = mentorRepository.findFetchUserByIdAndStatus(mentorId, ACTIVE)
                .orElseThrow(() -> new NoExistMentoringProfileException("신청하신 멘토링 멘토 정보가 존재하지 않습니다."));
        if(mentor.getUser().equals(user)) {
            throw new EqualUserMentorException("내 멘토링 서비스는 신청할 수 없습니다.");
        }

        // 결제 내역 저장
        Payment payment = paymentRepository.save(createRequest.getPayment().toEntity(user));

        // 멘토링 내역 저장
        mentoringRepository.save(createRequest.toEntity(user, mentor, payment));

    }

    public MentoringRes getMentoring(Long mentorId, Long userId) {

        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속하신 회원 정보가 존재하지 않습니다."));
        MentoringRes mentoringRes = mentorRepository.findByIdAndStatus(mentorId, ACTIVE)
                .map(MentoringRes::new)
                .orElseThrow(() -> new NoExistMentoringProfileException("신청하신 멘토링 멘토 정보가 존재하지 않습니다."));

        if(mentoringRes.getNickname().equals(user.getNickname())) {
            throw new EqualUserMentorException("내 멘토링 서비스는 신청할 수 없습니다.");
        }

        return mentoringRes;
    }
}
