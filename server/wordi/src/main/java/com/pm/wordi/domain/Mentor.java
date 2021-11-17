package com.pm.wordi.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mentor extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentorId")
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User uesr;

    @Column(name = "mentorNation")
    private String nation;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private boolean isProgress;

    private String profileImageUrl;

    private String introduction;

    private Long price;

    private String entryCertification;

    private String certification;

    @Enumerated(EnumType.STRING)
    private MentorLevel mentorLevel;

    private boolean isOpen;





}
