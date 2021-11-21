package com.pm.wordi.domain.mentor;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MentorSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentorScheduleId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentorId")
    private Mentor mentor;

    private String week;

    private String schedule;

    public void updateMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Builder
    public MentorSchedule(Mentor mentor, String week, String schedule) {
        this.mentor = mentor;
        this.week = week;
        this.schedule = schedule;
    }
}
