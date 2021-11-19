package com.pm.wordi.controller.dto;

import com.pm.wordi.commons.utils.certification.AES128;
import com.pm.wordi.commons.utils.certification.Secret;
import com.pm.wordi.domain.user.User;
import com.pm.wordi.domain.user.UserLevel;
import lombok.*;

public class UserDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateRequest {

        private String email;

        private String password;

        private String phoneNumber;

        private String nickname;

        private String nation1;

        private String nation2;

        private String nation3;

        private UserLevel userLevel;

        private boolean isMentor;

        private boolean isOAuth2;

        public void passwordEncryption() {
            this.password = new AES128(Secret.USER_INFO_PASSWORD_KEY).encrypt(this.password);
        }

        public User toEntity() {

            return User.builder()
                    .email(this.email)
                    .password(this.password)
                    .phoneNumber(this.phoneNumber)
                    .nickname(this.nickname)
                    .nation1(this.nation1)
                    .nation2(this.nation2)
                    .nation3(this.nation3)
                    .userLevel(UserLevel.일반)
                    .isMentor(false)
                    .isOAuth2(false)
                    .build();
        }

    }


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ResponseTokens {
        private Long userId;
        private String jwt;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LoginReq {
        private String email;
        private String password;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AccountRes {
        private String email;
        private String phoneNumber;

    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AccountReq {
        private String email;
        private String phoneNumber;

    }

}
