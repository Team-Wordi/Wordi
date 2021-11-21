package com.pm.wordi.controller.dto;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.Mentor;
import com.pm.wordi.domain.mentor.MentorKeyword;
import com.pm.wordi.domain.mentor.MentorLevel;
import com.pm.wordi.domain.mentor.MentorSchedule;
import com.pm.wordi.domain.mentoring.Mentoring;
import com.pm.wordi.domain.review.Review;
import com.pm.wordi.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MentorDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateRequest {

        private String profileImageUrl;

        private String mentorNation;

        private LocalDate startDate;

        private LocalDate endDate;

        private boolean isProgress;

        private List<String> keywordList = new ArrayList<>();

        private String introduction;

        private List<ScheduleDTO> scheduleList = new ArrayList<>();

        private Long price;

        private String entryCertification;

        private String certification;

        public Mentor toEntity(User user) {
            return Mentor.builder()
                    .user(user)
                    .profileImageUrl(this.profileImageUrl)
                    .nation(this.mentorNation)
                    .startDate(this.startDate)
                    .endDate(this.endDate)
                    .isProgress(this.isProgress)
                    .introduction(this.introduction)
                    .price(this.price)
                    .entryCertification(this.entryCertification)
                    .certification(this.certification)
                    .mentorLevel(MentorLevel.대기)
                    .status(BaseStatus.ACTIVE)
                    .build();
        }

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ScheduleDTO {
        private String week;
        private String schedule;

        public MentorSchedule toMentorSchedule(Mentor mentor) {
            return MentorSchedule.builder()
                    .mentor(mentor)
                    .week(this.week)
                    .schedule(this.schedule)
                    .build();

        }

        public ScheduleDTO(MentorSchedule mentorSchedule) {
            this.week = mentorSchedule.getWeek();
            this.schedule = mentorSchedule.getSchedule();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProfileRes {

        private String mentorNation;
        private LocalDate startDate;
        private LocalDate endDate;
        private boolean isProgress;
        private List<String> keywordList = new ArrayList<>();
        private String introduction;
        private List<ScheduleDTO> scheduleList = new ArrayList<>();
        private Long price;

        public ProfileRes(Mentor mentor) {
            this.mentorNation = mentor.getNation();
            this.startDate = mentor.getStartDate();
            this.endDate = mentor.getEndDate();
            this.isProgress = mentor.isProgress();
            this.keywordList = mentor.getMentorKeywordList().stream()
                    .map(k -> k.getKeyword()).collect(Collectors.toList());
            this.introduction = mentor.getIntroduction();
            this.scheduleList = mentor.getMentorScheduleList().stream()
                    .map(ScheduleDTO::new).collect(Collectors.toList());
            this.price = mentor.getPrice();
        }
    }

}
