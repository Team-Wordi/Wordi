package com.pm.wordi.domain.user;

import com.pm.wordi.controller.dto.UserDto;
import com.pm.wordi.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.pm.wordi.controller.dto.UserDto.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

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

    @Builder
    public User(Long id, String email, String password, String phoneNumber, String nickname,
                String nation1, String nation2, String nation3,
                UserLevel userLevel, boolean isMentor, boolean isOAuth2) {
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
}
