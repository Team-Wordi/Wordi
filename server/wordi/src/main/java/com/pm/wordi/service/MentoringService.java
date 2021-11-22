package com.pm.wordi.service;

import com.pm.wordi.domain.mentor.Mentor;
import com.pm.wordi.domain.mentor.MentorRepository;
import com.pm.wordi.domain.mentoring.Mentoring;
import com.pm.wordi.domain.mentoring.MentoringRepository;
import com.pm.wordi.domain.mentoring.Payment;
import com.pm.wordi.domain.mentoring.PaymentRepository;
import com.pm.wordi.domain.user.User;
import com.pm.wordi.domain.user.UserRepository;
import com.pm.wordi.exception.mentor.NoExistMentorException;
import com.pm.wordi.exception.mentor.NoExistMentoringProfileException;
import com.pm.wordi.exception.mentoring.EqualUserMentorException;
import com.pm.wordi.exception.mentoring.NoExistMentoringException;
import com.pm.wordi.exception.mentoring.NoExistPaymentException;
import com.pm.wordi.exception.user.NoExistUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    public void createMentoring(Long mentorId, Long userId, ApplicationReq applicationReq) {

        // 유저, 멘토 정보 조회
        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속하신 회원 정보가 존재하지 않습니다."));
        Mentor mentor = mentorRepository.findFetchUserByIdAndStatus(mentorId, ACTIVE)
                .orElseThrow(() -> new NoExistMentoringProfileException("신청하신 멘토링 멘토 정보가 존재하지 않습니다."));
        if(mentor.getUser().equals(user)) {
            throw new EqualUserMentorException("내 멘토링 서비스는 신청할 수 없습니다.");
        }

        // 결제 내역 저장
        Payment payment = paymentRepository.save(applicationReq.getPayment().toEntity(user));

        // 멘토링 내역 저장
        mentoringRepository.save(applicationReq.toEntity(user, mentor, payment));

    }

    @Transactional(readOnly = true)
    public ApplicationRes getMentoring(Long mentorId, Long userId) {

        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속하신 회원 정보가 존재하지 않습니다."));
        ApplicationRes applicationRes = mentorRepository.findByIdAndStatus(mentorId, ACTIVE)
                .map(ApplicationRes::new)
                .orElseThrow(() -> new NoExistMentoringProfileException("신청하신 멘토링 멘토 정보가 존재하지 않습니다."));

        if(applicationRes.getNickname().equals(user.getNickname())) {
            throw new EqualUserMentorException("내 멘토링 서비스는 신청할 수 없습니다.");
        }

        return applicationRes;
    }

    @Transactional(readOnly = true)
    public List<MentorMentoringRes> geMentoringListBytMentor(Long userId) {

        Mentor mentor = mentorRepository.findByUserIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistMentorException("해당 회원의 멘토 정보가 존재하지 않습니다."));

        return mentoringRepository.findAllByMentorIdAndStatus(mentor.getId(), ACTIVE).stream()
                .map(MentorMentoringRes::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<UserMentoringRes> geMentoringListByUser(Long userId) {
        return mentoringRepository.findAllByUserIdAndStatus(userId, ACTIVE).stream()
                .map(UserMentoringRes::new)
                .collect(Collectors.toList());
    }

    public RefundPaymentInfo decideMentoring(Long mentoringId, DecideReq decideReq) {
        Mentoring mentoring = mentoringRepository.findByIdAndStatus(mentoringId, ACTIVE)
                .orElseThrow(() -> new NoExistMentoringException("해당 멘토링 정보가 존재하지 않습니다."));

        mentoring.decideMentoring(decideReq);

        return paymentRepository.findById(mentoring.getPayment().getId())
                .map(RefundPaymentInfo::new)
                .orElseThrow(() -> new NoExistPaymentException("멘토링 정보에 해당하는 결제 정보가 없습니다."));
    }
}
