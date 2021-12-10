package com.pm.wordi.domain.user.entity;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private List<UserKeyword> userKeywordList = new ArrayList<>();

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isMentor == user.isMentor && isOAuth2 == user.isOAuth2 && Objects.equals(id, user.id)
                && Objects.equals(userKeywordList, user.userKeywordList) && Objects.equals(email, user.email)
                && Objects.equals(password, user.password) && Objects.equals(phoneNumber, user.phoneNumber)
                && Objects.equals(nickname, user.nickname) && Objects.equals(nation1, user.nation1)
                && Objects.equals(nation2, user.nation2) && Objects.equals(nation3, user.nation3)
                && userLevel == user.userLevel && status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userKeywordList, email, password, phoneNumber, nickname,
                nation1, nation2, nation3, userLevel, isMentor, isOAuth2, status);
    }

    // == 연관관계 편의 메서드 ==
    public void addKeyword(UserKeyword userKeyword) {
        userKeyword.updateUser(this);
        userKeywordList.add(userKeyword);
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

    public void updateDeleteStatus() {
        this.status = BaseStatus.INACTIVE;
    }

}
