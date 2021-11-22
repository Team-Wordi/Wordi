package com.pm.wordi.controller.dto;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.Mentor;
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

import java.time.LocalDateTime;

public class MentoringDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateRequest {

        private Long price;
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime requestSchedule1;
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime requestSchedule2;
        private String questions;
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
        private String orderNumber;
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
}
