package com.pm.wordi.domain.user;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static com.pm.wordi.controller.dto.UserDto.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<UserKeyword> keywordList = new ArrayList<>();

    private String email;

    private String password;

    private String phoneNumber;

    private String nickname;

    @Column(name = "userNation1")
    private String nation1;

    @Column(name = "userNation2")
    private String nation2;

    @Column(name = "userNation3")
    private String nation3;

    @Enumerated(EnumType.STRING)
    private UserLevel userLevel;

    private boolean isMentor;

    private boolean isOAuth2;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;


    // == 연관관계 편의 메서드 ==
    public void addKeyword(UserKeyword userKeyword) {
        userKeyword.updateKeyword(this);
        keywordList.add(userKeyword);
    }


    // == 생성자 ==

    @Builder
    public User(Long id, String email, String password, String phoneNumber, String nickname,
                String nation1, String nation2, String nation3, UserLevel userLevel,
                boolean isMentor, boolean isOAuth2, BaseStatus baseStatus ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.nation1 = nation1;
        this.nation2 = nation2;
        this.nation3 = nation3;
        this.userLevel = userLevel;
        this.isMentor = isMentor;
        this.isOAuth2 = isOAuth2;
        this.status = baseStatus;

    }

    public AccountRes toAccountRes() {
        return AccountRes.builder()
                .email(this.email)
                .phoneNumber(this.phoneNumber)
                .build();
    }

    public void updateAccount(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateProfile(ProfileReq profileReq) {
        this.nickname = profileReq.getNickname();
        this.nation1 = profileReq.getNation1();
        this.nation2 = profileReq.getNation2();
        this.nation3 = profileReq.getNation3();
    }

}
