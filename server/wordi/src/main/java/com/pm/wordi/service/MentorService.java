package com.pm.wordi.service;

import com.pm.wordi.commons.utils.file.FileNameUtils;
import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.mentor.entity.MentorKeyword;
import com.pm.wordi.domain.mentor.repository.MentorKeywordRepository;
import com.pm.wordi.domain.mentor.repository.MentorRepository;
import com.pm.wordi.domain.mentor.repository.MentorScheduleRepository;
import com.pm.wordi.domain.user.entity.User;
import com.pm.wordi.domain.user.repository.UserRepository;
import com.pm.wordi.exception.file.CertificationFileSaveFailedException;
import com.pm.wordi.exception.file.ImageSaveFailedException;
import com.pm.wordi.exception.mentor.ExistMentorException;
import com.pm.wordi.exception.mentor.NoExistMentorException;
import com.pm.wordi.exception.mentor.NoExistMentoringProfileException;
import com.pm.wordi.exception.user.NoExistUserException;
import com.pm.wordi.service.storage.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.pm.wordi.commons.utils.constants.CloudFrontConstants.CLOUD_FRONT_DOMAIN_NAME;
import static com.pm.wordi.controller.dto.MentorDto.*;
import static com.pm.wordi.domain.BaseStatus.*;

@Service
@RequiredArgsConstructor
@Transactional
public class MentorService {

    @Value("${file.path}")
    private String filePath;

    private final UserRepository userRepository;
    private final MentorRepository mentorRepository;
    private final MentorKeywordRepository mentorKeywordRepository;
    private final MentorScheduleRepository mentorScheduleRepository;

    private final AwsS3Service awsS3Service;

    @Transactional
    public void createMentor(Long userId, CreateRequest createRequest, @Nullable MultipartFile profileImage, MultipartFile certification) {

        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("접속한 회원 정보와 일치하는 회원 정보가 없습니다."));

        if(mentorRepository.countByUser(user)>=1) {
            throw new ExistMentorException("이미 가입하신 멘토 정보가 있습니다.");
        }

        // 프로필 이미지 파일 저장
        if (!profileImage.isEmpty()) {
            String s3SaveFileName = awsS3Service.uploadBucket(profileImage);
            String fileFullPath = "https://" + CLOUD_FRONT_DOMAIN_NAME + "/" + s3SaveFileName;
            createRequest.updateImageUrl(fileFullPath);
        }

        // 멘토 증명서 파일 저장
        if (!certification.isEmpty()) {
            String s3SaveFileName = awsS3Service.uploadBucket(certification);
            String fileFullPath = "https://" + CLOUD_FRONT_DOMAIN_NAME + "/" + s3SaveFileName;
            createRequest.updateCertificationUrl(certification.getOriginalFilename(), fileFullPath);
        }

        // 멘토 정보 저장
        Mentor mentor = mentorRepository.save(createRequest.toEntity(user));

        // 멘토 키워드 저장
        createRequest.getKeywordList().stream()
                .forEach(k -> mentorKeywordRepository.save(new MentorKeyword(mentor, k)));

        // 멘토 일정 저장
        createRequest.getScheduleList().stream()
                .forEach(s -> mentorScheduleRepository.save(s.toMentorSchedule(mentor)));
    }

    @Transactional(readOnly = true)
    public ProfileRes getProfile(Long userId) {
        return mentorRepository.findByUserIdAndStatus(userId, ACTIVE)
                .map(ProfileRes::new)
                .orElseThrow(() -> new NoExistMentorException("해당 회원의 멘토 정보가 존재하지 않습니다."));

    }

    @Transactional
    public void updateProfile(Long userId, ProfileReq profileReq) {

        Mentor mentor = mentorRepository.findByUserIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistMentorException("해당 회원의 멘토 정보가 존재하지 않습니다."));

        mentor.updateProfile(profileReq);

        // 키워드 업데이트
        mentorKeywordRepository.deleteByMentor(mentor);
        profileReq.getKeywordList().stream()
                .forEach(k -> mentorKeywordRepository.save(new MentorKeyword(mentor, k)));

        // 일정 업데이트
        mentorScheduleRepository.deleteByMentor(mentor);
        profileReq.getScheduleList().stream()
                .forEach(s -> mentorScheduleRepository.save(s.toMentorSchedule(mentor)));

    }

    @Transactional(readOnly = true)
    public List<ProfileListRes> searchProfileList(String nationCond, String keywordCond, Long monthCond) {

        //TODO. 날짜도 QueryDsl 안에서 처리하기(startDate, endDate 차이를 QueryDsl 로직 안에서 구해야하는 과제)
        if(monthCond!=null) {
            return mentorRepository.searchProfileList(nationCond, keywordCond).stream()
                    .map(ProfileListRes::new)
                    .filter(p->p.getMonthPeriod()>=monthCond)
                    .collect(Collectors.toList());
        }

        return mentorRepository.searchProfileList(nationCond, keywordCond).stream()
                .map(ProfileListRes::new)
                .collect(Collectors.toList());
        
    }

    @Transactional(readOnly = true)
    public MentoringProfileRes getMentoringProfile(Long mentorId) {
        return mentorRepository.findByIdAndStatus(mentorId, ACTIVE)
                .map(MentoringProfileRes::new)
                .orElseThrow(() -> new NoExistMentoringProfileException("해당 멘토 프로필이 존재하지 않습니다."));
    }
}
