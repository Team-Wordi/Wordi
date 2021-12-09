package com.pm.wordi.controller.dto;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.mentor.entity.MentorLevel;
import com.pm.wordi.domain.mentor.entity.MentorSchedule;
import com.pm.wordi.domain.review.entity.Review;
import com.pm.wordi.domain.user.entity.User;
import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MentorDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateRequest {

        @NotBlank(message = "멘토 관심 국가를 입력해 주세요.")
        private String mentorNation;

        @NotNull(message = "워킹홀리데이 시작 날짜를 입력해 주세요.")
        private LocalDate startDate;

        @NotNull(message = "워킹홀리데이 끝 날짜를 입력해 주세요.")
        private LocalDate endDate;

        private boolean isProgress;

        private List<String> keywordList = new ArrayList<>();

        @Size(max = 100, message = "멘토 프로필 소개는 최대 100자입니다.")
        @NotBlank(message = "멘토 프로필 소개를 입력해주세요.")
        private String profileIntroduction;

        @NotBlank(message = "멘토링 소개를 입력해주세요.")
        private String introduction;

        @NotEmpty(message = "일정을 1개 이상 입력해 주세요.")
        private List<ScheduleDTO> scheduleList = new ArrayList<>();

        @NotNull(message = "가격을 입력해 주세요.")
        private Long price;


        private String profileImageUrl;

        private String certificationName;
        private String certificationUrl;


        public Mentor toEntity(User user) {
            return Mentor.builder()
                    .user(user)
                    .profileImageUrl(this.profileImageUrl)
                    .nation(this.mentorNation)
                    .startDate(this.startDate)
                    .endDate(this.endDate)
                    .isProgress(this.isProgress)
                    .profileIntroduction(this.profileIntroduction)
                    .introduction(this.introduction)
                    .price(this.price)
                    .certificationName(this.certificationName)
                    .certificationUrl(this.certificationUrl)
                    .mentorLevel(MentorLevel.대기)
                    .status(BaseStatus.ACTIVE)
                    .build();
        }

        public void updateImageUrl(String imageUrl) {
            this.profileImageUrl = imageUrl;
        }

        public void updateCertificationUrl(String certificationName, String certificationUrl) {
            this.certificationName = certificationName;
            this.certificationUrl = certificationUrl;
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
        private String profileIntroduction;
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
            this.profileIntroduction = mentor.getProfileIntroduction();
            this.introduction = mentor.getIntroduction();
            this.scheduleList = mentor.getMentorScheduleList().stream()
                    .map(ScheduleDTO::new).collect(Collectors.toList());
            this.price = mentor.getPrice();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProfileReq {

        @NotBlank(message = "멘토 관심 국가를 입력해 주세요.")
        private String mentorNation;

        @NotNull(message = "워킹홀리데이 시작 날짜를 입력해 주세요.")
        private LocalDate startDate;

        @NotNull(message = "워킹홀리데이 끝 날짜를 입력해 주세요.")
        private LocalDate endDate;

        private boolean isProgress;

        private List<String> keywordList = new ArrayList<>();

        @NotBlank(message = "멘토 프로필 소개를 입력해주세요.")
        private String profileIntroduction;

        @NotBlank(message = "멘토링 소개를 입력해주세요.")
        private String introduction;

        @NotEmpty(message = "일정을 1개 이상 입력해 주세요.")
        private List<ScheduleDTO> scheduleList = new ArrayList<>();

        @NotNull(message = "가격을 입력해 주세요.")
        private Long price;


    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProfileListRes {
        private Long id;
        private String profileImageUrl;
        private String nickname;
        private String mentorNation;
        private Long monthPeriod;
        private List<String> keywordList = new ArrayList<>();

        public ProfileListRes(Mentor mentor) {
            this.id = mentor.getId();
            this.profileImageUrl = mentor.getProfileImageUrl();
            this.nickname = mentor.getUser().getNickname();
            this.mentorNation = mentor.getNation();
            this.monthPeriod = mentor.getEndDate() != null ?
                     ChronoUnit.MONTHS.between(mentor.getStartDate(), mentor.getEndDate()) :
                     ChronoUnit.MONTHS.between(mentor.getStartDate(), LocalDate.now());
            this.keywordList = mentor.getMentorKeywordList().stream()
                    .map(k -> k.getKeyword())
                    .collect(Collectors.toList());

        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MentoringProfileRes {

        private String profileImageUrl;
        private String nickname;
        private String mentorNation;
        private Long monthPeriod;
        private String profileIntroduction;
        private List<String> keywordList = new ArrayList<>();

        private String introduce;
        private List<ReviewDTO> reviewList = new ArrayList<>();
        private Long price;
        private List<ScheduleDTO> mentorScheduleList = new ArrayList<>();

        public MentoringProfileRes(Mentor mentor) {
            this.profileImageUrl = mentor.getProfileImageUrl();
            this.nickname = mentor.getUser().getNickname();
            this.mentorNation = mentor.getNation();
            this.monthPeriod = ChronoUnit.MONTHS.between(mentor.getStartDate(), mentor.getEndDate());
            this.profileIntroduction = mentor.getProfileIntroduction();
            this.keywordList = mentor.getMentorKeywordList().stream()
                    .map(k -> k.getKeyword())
                    .collect(Collectors.toList());

            this.introduce = mentor.getIntroduction();
            this.reviewList = mentor.getReviewList().stream()
                    .map(ReviewDTO::new)
                    .collect(Collectors.toList());
            this.price = mentor.getPrice();
            this.mentorScheduleList = mentor.getMentorScheduleList().stream()
                    .map(ScheduleDTO::new)
                    .collect(Collectors.toList());
        }

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReviewDTO {
        private Long id;
        private String nickname;
        private String content;
        private LocalDate writeDate;

        public ReviewDTO(Review review) {
            this.id = review.getId();
            this.nickname = review.getUser().getNickname();
            this.content = review.getContent();
            this.writeDate = review.getUpdated().toLocalDate();
        }
    }


}
