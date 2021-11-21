package com.pm.wordi.domain.mentor;

import com.pm.wordi.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MentorKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentorKeywordId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentorId")
    private Mentor mentor;

    private String keyword;


    @Builder
    public MentorKeyword(Mentor mentor, String keyword) {
        this.mentor = mentor;
        this.keyword = keyword;
    }

    public void updateMentor(Mentor mentor) {
        this.mentor = mentor;
    }

}
