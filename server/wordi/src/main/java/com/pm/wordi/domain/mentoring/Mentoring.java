package com.pm.wordi.domain.mentoring;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.BaseTimeEntity;
import com.pm.wordi.domain.mentor.Mentor;
import com.pm.wordi.domain.user.User;
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
}
