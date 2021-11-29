package com.pm.wordi.controller.dto;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.review.entity.Review;
import com.pm.wordi.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReviewDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateRequest {
        private Long mentorId;
        private String mentorNickname;
        private String mentorNation;
        private String contents;

        public Review toEntity(User user, Mentor mentor) {
            return Review.builder()
                    .user(user)
                    .mentor(mentor)
                    .content(this.contents)
                    .status(BaseStatus.ACTIVE)
                    .build();

        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateReviewPage {
        private Long mentorId;
        private String mentorNickname;
        private String mentorNation;

        public CreateReviewPage(Mentor mentor) {
            this.mentorId = mentor.getId();
            this.mentorNickname = mentor.getUser().getNickname();
            this.mentorNation = mentor.getNation();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReviewRes {
        private Long reviewId;
        private String mentorNickname;
        private String mentorNation;
        private String contents;
        private String writer;
        private LocalDateTime writeDate;

        public ReviewRes(Review review) {
            this.reviewId = review.getId();
            this.mentorNickname = review.getMentor().getUser().getNickname();
            this.mentorNation = review.getMentor().getNation();
            this.contents = review.getContent();
            this.writer = review.getUser().getNickname();
            this.writeDate = review.getUpdated();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReviewReq {
        private String contents;
    }
}
