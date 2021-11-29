package com.pm.wordi.service;

import com.pm.wordi.controller.dto.ReviewDto;
import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.mentor.repository.MentorRepository;
import com.pm.wordi.domain.mentoring.repository.MentoringRepository;
import com.pm.wordi.domain.review.repository.ReviewRepository;
import com.pm.wordi.domain.user.entity.User;
import com.pm.wordi.domain.user.repository.UserRepository;
import com.pm.wordi.exception.mentor.NoExistMentorException;
import com.pm.wordi.exception.user.NoExistUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.pm.wordi.controller.dto.ReviewDto.*;
import static com.pm.wordi.domain.BaseStatus.ACTIVE;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MentorRepository mentorRepository;
    private final MentoringRepository mentoringRepository;

    @Transactional
    public void createReview(Long userId, CreateRequest createRequest) {
        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보와 일치하는 회원 정보가 없습니다."));

        Mentor mentor = mentorRepository.findFetchUserByIdAndStatus(createRequest.getMentorId(), ACTIVE)
                .orElseThrow(() -> new NoExistMentorException("해당 멘토 정보가 존재하지 않습니다."));

        reviewRepository.save(createRequest.toEntity(user, mentor));
    }

    @Transactional(readOnly = true)
    public CreateReviewPage getCreateReviewPage(Long mentoringId) {
        return mentoringRepository.findMentorById(mentoringId).map(CreateReviewPage::new)
                .orElseThrow(() -> new NoExistMentorException("해당 멘토 정보가 존재하지 않습니다."));

    }

    @Transactional(readOnly = true)
    public List<reviewRes> getReviewListByUser(Long userId) {
        return reviewRepository.findAllByUserIdAndStatus(userId, ACTIVE).stream()
                .map(reviewRes::new)
                .collect(Collectors.toList());
    }
}
