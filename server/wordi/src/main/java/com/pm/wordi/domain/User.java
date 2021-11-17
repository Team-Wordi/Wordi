package com.pm.wordi.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity{

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





}
