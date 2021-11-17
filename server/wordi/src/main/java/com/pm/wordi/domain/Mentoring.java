package com.pm.wordi.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mentoring extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentoringId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "mentorId")
    private Mentor mentor;

    @OneToOne
    @JoinColumn(name = "paymentId")
    private Payment payment;

    private Long price;

    private LocalDateTime requestSchedule1;

    private LocalDateTime requestSchedule2;

    private String questions;

    @Enumerated(EnumType.STRING)
    private MentoringStatus mentoringStatus;

    private String refusalMessage;



}
