package com.pm.wordi.controller.dto;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.review.entity.Review;
import com.pm.wordi.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
