package com.pm.wordi.domain.mentoring.entity;

import com.pm.wordi.controller.dto.MentoringDto.DecideReq;
import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.BaseTimeEntity;
import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mentoring extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentoringId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentorId")
    private Mentor mentor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentId")
    private Payment payment;

    private Long price;

    private LocalDateTime requestSchedule1;

    private LocalDateTime requestSchedule2;

    private LocalDateTime selectedSchedule;

    private String questions;

    @Enumerated(EnumType.STRING)
    private MentoringStatus mentoringStatus;

    private String refusalMessage;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;


    public void updateMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Builder
    public Mentoring(User user, Mentor mentor, Payment payment, Long price,
                     LocalDateTime requestSchedule1, LocalDateTime requestSchedule2,
                     String questions, MentoringStatus mentoringStatus, BaseStatus status) {
        this.user = user;
        this.mentor = mentor;
        this.payment = payment;
        this.price = price;
        this.requestSchedule1 = requestSchedule1;
        this.requestSchedule2 = requestSchedule2;
        this.questions = questions;
        this.mentoringStatus = mentoringStatus;
        this.status = status;
    }

    public void decideMentoring(DecideReq decideReq) {
        if(decideReq.isDecision()) {
            this.mentoringStatus = MentoringStatus.예약확정;
            this.selectedSchedule = decideReq.getSelectedSchedule();
            this.payment.updatePaymentStatus(PaymentStatus.결제완료);
        }

        if(!decideReq.isDecision()) {
            this.mentoringStatus = MentoringStatus.예약거절;
            this.refusalMessage = decideReq.getRefusalMessage();
            this.payment.updatePaymentStatus(PaymentStatus.환불);
        }
    }

    public void cancelMentoring() {
        this.mentoringStatus = MentoringStatus.예약취소;
        this.payment.updatePaymentStatus(PaymentStatus.결제취소);
    }
}
