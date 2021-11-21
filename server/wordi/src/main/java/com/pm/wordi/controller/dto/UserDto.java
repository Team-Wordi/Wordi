package com.pm.wordi.controller.dto;

import com.pm.wordi.commons.utils.certification.AES128;
import com.pm.wordi.commons.utils.certification.Secret;
import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.user.User;
import com.pm.wordi.domain.user.UserKeyword;
import com.pm.wordi.domain.user.UserLevel;
import lombok.*;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateRequest {

        @NotBlank(message = "이메일 주소를 입력해주세요.")
        @Email(message = "올바른 이메일 주소를 입력해주세요.")
        private String email;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
        private String password;

        @NotBlank(message = "휴대폰 번호를 입력해주세요.")
        @Pattern(regexp = "(?:(010-\\d{4})|(01[1|6|7|8|9]-\\d{3,4}))-(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
        private String phoneNumber;

        @NotBlank(message = "닉네임을 입력해주세요.")
        @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하로 입력해주세요.")
        private String nickname;

        @NotBlank(message = "첫 번째 관심 국가를 입력해주세요.")
        private String nation1;

        private String nation2;

        private String nation3;

        private List<String> keywordList = new ArrayList<>();


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
                    .baseStatus(BaseStatus.ACTIVE)
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

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AccountReq {

        @NotBlank(message = "이메일 주소를 입력해주세요.")
        @Email(message = "올바른 이메일 주소를 입력해주세요.")
        private String email;

        @NotBlank(message = "휴대폰 번호를 입력해주세요.")
        @Pattern(regexp = "(?:(010-\\d{4})|(01[1|6|7|8|9]-\\d{3,4}))-(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
        private String phoneNumber;

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class changePasswordReq {

        private String beforePassword;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
        private String afterPassword;

        public void passwordEncryption() {
            this.beforePassword = new AES128(Secret.USER_INFO_PASSWORD_KEY).encrypt(this.beforePassword);
            this.afterPassword = new AES128(Secret.USER_INFO_PASSWORD_KEY).encrypt(this.afterPassword);
        }

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProfileRes {
        private String nickname;
        private String nation1;
        private String nation2;
        private String nation3;
        private List<String> KeywordList;


        public ProfileRes(User user) {
            this.nickname = user.getNickname();
            this.nation1 = user.getNation1();
            this.nation2 = user.getNation2();
            this.nation3 = user.getNation3();
            KeywordList = user.getKeywordList().stream()
                    .map(k -> k.getKeyword()).collect(Collectors.toList());
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ProfileReq {
        @NotBlank(message = "닉네임을 입력해주세요.")
        @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하로 입력해주세요.")
        private String nickname;

        @NotBlank(message = "첫 번째 관심 국가를 입력해주세요.")
        private String nation1;
        private String nation2;
        private String nation3;

        private List<String> KeywordList = new ArrayList<>();

    }



}
