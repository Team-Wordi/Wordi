package com.pm.wordi.domain.mentor;

import com.pm.wordi.controller.dto.MentorDto;
import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.BaseTimeEntity;
import com.pm.wordi.domain.mentoring.Mentoring;
import com.pm.wordi.domain.review.Review;
import com.pm.wordi.domain.user.User;
import com.pm.wordi.domain.user.UserKeyword;
import com.pm.wordi.domain.user.UserLevel;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.pm.wordi.controller.dto.MentorDto.*;

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

    @OneToMany(mappedBy = "mentor")
    private List<MentorKeyword> mentorKeywordList = new ArrayList<>();

    @OneToMany(mappedBy = "mentor")
    private List<MentorSchedule> mentorScheduleList = new ArrayList<>();

    @OneToMany(mappedBy = "mentor")
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "mentor")
    private List<Mentoring> mentoringList = new ArrayList<>();

    @Column(name = "mentorNation")
    private String nation;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean isProgress;

    private String profileImageUrl;

    private String introduction;

    private Long price;

    private String entryCertification;

    private String certification;

    @Enumerated(EnumType.STRING)
    private MentorLevel mentorLevel;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;

    // == 연관관계 편의 메서드
    public void addMentorKeywordList(MentorKeyword mentorKeyword) {
        mentorKeyword.updateMentor(this);
        mentorKeywordList.add(mentorKeyword);
    }

    public void addMentorScheduleList(MentorSchedule mentorSchedule) {
        mentorSchedule.updateMentor(this);
        mentorScheduleList.add(mentorSchedule);
    }

    public void addReviewList(Review review) {
        review.updateMentor(this);
        reviewList.add(review);
    }

    public void addMentoringList(Mentoring mentoring) {
        mentoring.updateMentor(this);
        mentoringList.add(mentoring);
    }

    // == 생성자 ==

    @Builder
    public Mentor(User user, String nation, LocalDate startDate, LocalDate endDate,
                  boolean isProgress, String profileImageUrl, String introduction, Long price,
                  String entryCertification, String certification, MentorLevel mentorLevel, BaseStatus status) {
        this.user = user;
        this.nation = nation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isProgress = isProgress;
        this.profileImageUrl = profileImageUrl;
        this.introduction = introduction;
        this.price = price;
        this.entryCertification = entryCertification;
        this.certification = certification;
        this.mentorLevel = mentorLevel;
        this.status = status;
    }

    public void updateProfile(ProfileReq profileReq) {
        this.nation = profileReq.getMentorNation();
        this.startDate = profileReq.getStartDate();
        this.endDate = profileReq.getEndDate();
        this.isProgress = profileReq.isProgress();
        this.introduction = profileReq.getIntroduction();
        this.price = profileReq.getPrice();
    }
}
