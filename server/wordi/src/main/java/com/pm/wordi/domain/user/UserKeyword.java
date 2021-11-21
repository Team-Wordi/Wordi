package com.pm.wordi.domain.user;

import com.pm.wordi.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userKeywordId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    private String keyword;

    @Builder
    public UserKeyword(User user, String keyword) {
        this.user = user;
        this.keyword = keyword;
    }

    public void updateKeyword(User user) {
        this.user = user;
    }
}
