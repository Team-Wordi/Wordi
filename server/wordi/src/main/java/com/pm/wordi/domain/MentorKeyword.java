package com.pm.wordi.domain;

import lombok.AccessLevel;
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

    @ManyToOne
    @JoinColumn(name = "mentorId")
    private Mentor mentor;

    @Enumerated(EnumType.STRING)
    private Keyword keyword;

}
