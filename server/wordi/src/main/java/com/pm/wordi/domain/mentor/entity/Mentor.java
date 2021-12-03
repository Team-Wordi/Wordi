package com.pm.wordi.domain.mentor.entity;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.BaseTimeEntity;
import com.pm.wordi.domain.mentoring.entity.Mentoring;
import com.pm.wordi.domain.review.entity.Review;
import com.pm.wordi.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private String profileIntroduction;

    private String introduction;

    private Long price;

    private String certificationName;

    private String certificationUrl;

    @Enumerated(EnumType.STRING)
    private MentorLevel mentorLevel;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mentor mentor = (Mentor) o;
        return isProgress == mentor.isProgress && Objects.equals(id, mentor.id) && Objects.equals(user, mentor.user)
                && Objects.equals(mentorKeywordList, mentor.mentorKeywordList)
                && Objects.equals(mentorScheduleList, mentor.mentorScheduleList)
                && Objects.equals(reviewList, mentor.reviewList) && Objects.equals(mentoringList, mentor.mentoringList)
                && Objects.equals(nation, mentor.nation) && Objects.equals(startDate, mentor.startDate)
                && Objects.equals(endDate, mentor.endDate) && Objects.equals(profileImageUrl, mentor.profileImageUrl)
                && Objects.equals(profileIntroduction, mentor.profileIntroduction)
                && Objects.equals(introduction, mentor.introduction) && Objects.equals(price, mentor.price)
                && Objects.equals(certificationName, mentor.certificationName)
                && Objects.equals(certificationUrl, mentor.certificationUrl) && mentorLevel == mentor.mentorLevel
                && status == mentor.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, mentorKeywordList, mentorScheduleList, reviewList, mentoringList,
                nation, startDate, endDate, isProgress, profileImageUrl, profileIntroduction, introduction,
                price, certificationName, certificationUrl, mentorLevel, status);
    }

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
    public Mentor(User user, String nation, LocalDate startDate, LocalDate endDate, boolean isProgress,
                  String profileImageUrl, String profileIntroduction, String introduction, Long price,
                  String certificationName, String certificationUrl, MentorLevel mentorLevel, BaseStatus status) {
        this.user = user;
        this.nation = nation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isProgress = isProgress;
        this.profileImageUrl = profileImageUrl;
        this.profileIntroduction = profileIntroduction;
        this.introduction = introduction;
        this.price = price;
        this.certificationName = certificationName;
        this.certificationUrl = certificationUrl;
        this.mentorLevel = mentorLevel;
        this.status = status;
    }

    public void updateProfile(ProfileReq profileReq) {
        this.nation = profileReq.getMentorNation();
        this.startDate = profileReq.getStartDate();
        this.endDate = profileReq.getEndDate();
        this.isProgress = profileReq.isProgress();
        this.profileIntroduction = profileReq.getProfileIntroduction();
        this.introduction = profileReq.getIntroduction();
        this.price = profileReq.getPrice();
    }


}
