package com.pm.wordi.domain.mentor;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.BaseTimeEntity;
import com.pm.wordi.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mentor extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentorId")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

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

    @Enumerated(EnumType.STRING)
    private BaseStatus status;




}
