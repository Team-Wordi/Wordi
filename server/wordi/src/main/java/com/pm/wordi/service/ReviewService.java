package com.pm.wordi.service;

import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.mentor.repository.MentorRepository;
import com.pm.wordi.domain.mentoring.repository.MentoringRepository;
import com.pm.wordi.domain.review.entity.Review;
import com.pm.wordi.domain.review.repository.ReviewRepository;
import com.pm.wordi.domain.user.entity.User;
import com.pm.wordi.domain.user.repository.UserRepository;
import com.pm.wordi.exception.mentor.NoExistMentorException;
import com.pm.wordi.exception.review.NoExistReviewException;
import com.pm.wordi.exception.review.NoMatchUserReviewException;
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
    public List<ReviewRes> getReviewListByUser(Long userId) {
        return reviewRepository.findAllByUserIdAndStatus(userId, ACTIVE).stream()
                .map(ReviewRes::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ReviewRes> getReviewListByMentor(Long mentorId) {
        return reviewRepository.findAllByMentorIdAndStatus(mentorId, ACTIVE).stream()
                .map(ReviewRes::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ReviewRes getReview(Long reviewId) {
        return reviewRepository.findByIdAndStatus(reviewId, ACTIVE).map(ReviewRes::new)
                .orElseThrow(() -> new NoExistReviewException("해당 리뷰가 존재하지 않습니다."));
    }

    @Transactional
    public void updateReview(Long userId, Long reviewId, ReviewReq reviewReq) {
        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보와 일치하는 회원 정보가 없습니다."));

        Review review = reviewRepository.findByIdAndStatus(reviewId, ACTIVE)
                .orElseThrow(() -> new NoExistReviewException("해당 리뷰가 존재하지 않습니다."));

        if(review.getUser()!=user) {
            throw new NoMatchUserReviewException("해당 리뷰 수정에 권한이 없습니다.");
        }

        review.updateContents(reviewReq);
    }

}
