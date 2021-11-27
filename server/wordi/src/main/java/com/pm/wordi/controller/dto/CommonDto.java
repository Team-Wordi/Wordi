package com.pm.wordi.controller.dto;

import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.review.entity.Review;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CommonDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MainRes{
        private List<ReviewDTO> reviewDTOList;
        private List<MentorDTO> mentorDTOList;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReviewDTO{
        private String mentorNation;
        private String mentorNickname;
        private Long mentorPeriod;
        private String content;
        private String userNickname;
        private LocalDateTime writeDate;

        public ReviewDTO(Review review) {
            this.mentorNation = review.getMentor().getNation();
            this.mentorNickname = review.getMentor().getUser().getNickname();
            this.mentorPeriod = ChronoUnit.MONTHS.between(review.getMentor().getStartDate(), review.getMentor().getEndDate());
            this.content = review.getContent();
            this.userNickname = review.getUser().getNickname();
            this.writeDate = review.getUpdated();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MentorDTO{
        private String profileImageUrl;
        private String nation;
        private String nickname;
        private Long period;

        public MentorDTO(Mentor mentor) {
            this.profileImageUrl = mentor.getProfileImageUrl();
            this.nation = mentor.getNation();
            this.nickname = mentor.getUser().getNickname();
            this.period = ChronoUnit.MONTHS.between(mentor.getStartDate(), mentor.getEndDate());
        }
    }


}
