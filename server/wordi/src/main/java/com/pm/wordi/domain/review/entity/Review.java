package com.pm.wordi.domain.review.entity;

import com.pm.wordi.controller.dto.ReviewDto;
import com.pm.wordi.controller.dto.ReviewDto.ReviewReq;
import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.BaseTimeEntity;
import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentorId")
    private Mentor mentor;

    private String content;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;

    public void updateMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public void updateContents(ReviewReq reviewReq) {
        this.content = reviewReq.getContents();
    }

    public void deleteStatus() {
        this.status = BaseStatus.INACTIVE;
    }

    @Builder
    public Review(User user, Mentor mentor, String content, BaseStatus status) {
        this.user = user;
        this.mentor = mentor;
        this.content = content;
        this.status = status;
    }
}
