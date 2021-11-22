package com.pm.wordi.controller.dto;

import com.pm.wordi.controller.dto.MentorDto.ScheduleDTO;
import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.Mentor;
import com.pm.wordi.domain.mentor.MentorSchedule;
import com.pm.wordi.domain.mentoring.Mentoring;
import com.pm.wordi.domain.mentoring.MentoringStatus;
import com.pm.wordi.domain.mentoring.Payment;
import com.pm.wordi.domain.mentoring.PaymentStatus;
import com.pm.wordi.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MentoringDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ApplicationReq {

        @NotNull(message = "가격 정보가 입력되지 않았습니다.")
        private Long price;

        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime requestSchedule1;

        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime requestSchedule2;

        @NotBlank(message = "사전 질문을 기입해주세요.")
        private String questions;

        @Valid
        private paymentDTO payment;

        public Mentoring toEntity(User user, Mentor mentor, Payment payment) {

            return Mentoring.builder()
                    .user(user)
                    .mentor(mentor)
                    .payment(payment)
                    .price(this.price)
                    .requestSchedule1(this.requestSchedule1)
                    .requestSchedule2(this.requestSchedule2)
                    .questions(this.questions)
                    .mentoringStatus(MentoringStatus.승인대기)
                    .status(BaseStatus.ACTIVE)
                    .build();

        }

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class paymentDTO {

        @NotBlank(message = "주문번호가 입력되지 않았습니다.")
        private String orderNumber;

        @NotNull(message = "가격 정보가 입력되지 않았습니다.")
        private Long price;

        private String depositor;
        private String bankCode;
        private String accountNumber;

        public Payment toEntity(User user) {
            return Payment.builder()
                    .user(user)
                    .orderNumber(this.orderNumber)
                    .price(this.price)
                    .depositor(this.depositor)
                    .bankCode(this.bankCode)
                    .accountNumber(this.accountNumber)
                    .paymentStatus(PaymentStatus.결제보류)
                    .status(BaseStatus.ACTIVE)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ApplicationRes {
        private String nickname;
        private String mentorNation;
        private Long price;
        private List<ScheduleDTO> mentorScheduleList = new ArrayList<>();

        public ApplicationRes(Mentor mentor) {
            this.nickname = mentor.getUser().getNickname();
            this.mentorNation = mentor.getNation();
            this.price = mentor.getPrice();
            this.mentorScheduleList = mentor.getMentorScheduleList().stream()
                    .map(ScheduleDTO::new)
                    .collect(Collectors.toList());
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MentorMentoringRes {
        private Long mentoringId;
        private Long paymentId;
        private MentoringStatus mentoringStatus;
        private String userNickname;
        private LocalDateTime requestSchedule1;
        private LocalDateTime requestSchedule2;
        private LocalDateTime selectedSchedule;
        private String questions;

        public MentorMentoringRes(Mentoring mentoring) {
            this.mentoringId = mentoring.getId();
            this.paymentId = mentoring.getPayment().getId();
            this.mentoringStatus = mentoring.getMentoringStatus();
            this.userNickname = mentoring.getUser().getNickname();
            this.requestSchedule1 = mentoring.getRequestSchedule1();
            this.requestSchedule2 = mentoring.getRequestSchedule2();
            this.selectedSchedule = mentoring.getSelectedSchedule();
            this.questions = mentoring.getQuestions();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserMentoringRes {
        private Long mentoringId;
        private Long paymentId;
        private MentoringStatus mentoringStatus;
        private String mentorNickname;
        private String mentorNation;
        private List<String> keywords;
        private LocalDateTime requestSchedule1;
        private LocalDateTime requestSchedule2;
        private LocalDateTime selectedSchedule;
        private String questions;

        public UserMentoringRes(Mentoring mentoring) {
            this.mentoringId = mentoring.getId();
            this.paymentId = mentoring.getPayment().getId();
            this.mentoringStatus = mentoring.getMentoringStatus();
            this.mentorNickname = mentoring.getMentor().getUser().getNickname();
            this.mentorNation = mentoring.getMentor().getNation();
            this.keywords = mentoring.getMentor().getMentorKeywordList().stream()
                    .map(k -> k.getKeyword())
                    .collect(Collectors.toList());
            this.requestSchedule1 = mentoring.getRequestSchedule1();
            this.requestSchedule2 = mentoring.getRequestSchedule2();
            this.selectedSchedule = mentoring.getSelectedSchedule();
            this.questions = mentoring.getQuestions();
        }
    }

}
