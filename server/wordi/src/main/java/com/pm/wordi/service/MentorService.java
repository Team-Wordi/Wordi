package com.pm.wordi.service;

import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.mentor.entity.MentorKeyword;
import com.pm.wordi.domain.mentor.repository.MentorKeywordRepository;
import com.pm.wordi.domain.mentor.repository.MentorRepository;
import com.pm.wordi.domain.mentor.repository.MentorScheduleRepository;
import com.pm.wordi.domain.mentoring.repository.MentoringRepository;
import com.pm.wordi.domain.user.entity.User;
import com.pm.wordi.domain.user.repository.UserRepository;
import com.pm.wordi.exception.mentor.ExistMentorException;
import com.pm.wordi.exception.mentor.ExistNotFinishMentoringByMentorException;
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
    private final MentoringRepository mentoringRepository;

    private final AwsS3Service awsS3Service;

    @Transactional
    public void createMentor(Long userId, CreateRequest createRequest, @Nullable MultipartFile profileImage, MultipartFile certification) {

        User user = userRepository.findByIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistUserException("????????? ?????? ????????? ???????????? ?????? ????????? ????????????."));

        if(mentorRepository.countByUser(user)>=1) {
            throw new ExistMentorException("?????? ???????????? ?????? ????????? ????????????.");
        }

        // ????????? ????????? ?????? ??????
        if (!profileImage.isEmpty()) {
            String s3SaveFileName = awsS3Service.uploadBucket(profileImage);
            String fileFullPath = "https://" + CLOUD_FRONT_DOMAIN_NAME + "/" + s3SaveFileName;
            createRequest.updateImageUrl(fileFullPath);
        }

        // ?????? ????????? ?????? ??????
        if (!certification.isEmpty()) {
            String s3SaveFileName = awsS3Service.uploadBucket(certification);
            String fileFullPath = "https://" + CLOUD_FRONT_DOMAIN_NAME + "/" + s3SaveFileName;
            createRequest.updateCertificationUrl(certification.getOriginalFilename(), fileFullPath);
        }

        // ?????? ?????? ??????
        Mentor mentor = mentorRepository.save(createRequest.toEntity(user));

        // ?????? ????????? ??????
        createRequest.getKeywordList().stream()
                .forEach(k -> mentorKeywordRepository.save(new MentorKeyword(mentor, k)));

        // ?????? ?????? ??????
        createRequest.getScheduleList().stream()
                .forEach(s -> mentorScheduleRepository.save(s.toMentorSchedule(mentor)));
    }

    @Transactional(readOnly = true)
    public ProfileRes getProfile(Long userId) {
        return mentorRepository.findByUserIdAndStatus(userId, ACTIVE)
                .map(ProfileRes::new)
                .orElseThrow(() -> new NoExistMentorException("?????? ????????? ?????? ????????? ???????????? ????????????."));

    }

    @Transactional
    public void updateProfile(Long userId, ProfileReq profileReq) {

        Mentor mentor = mentorRepository.findByUserIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistMentorException("?????? ????????? ?????? ????????? ???????????? ????????????."));

        mentor.updateProfile(profileReq);

        // ????????? ????????????
        mentorKeywordRepository.deleteByMentor(mentor);
        profileReq.getKeywordList().stream()
                .forEach(k -> mentorKeywordRepository.save(new MentorKeyword(mentor, k)));

        // ?????? ????????????
        mentorScheduleRepository.deleteByMentor(mentor);
        profileReq.getScheduleList().stream()
                .forEach(s -> mentorScheduleRepository.save(s.toMentorSchedule(mentor)));

    }

    @Transactional(readOnly = true)
    public List<ProfileListRes> searchProfileList(String nationCond, String keywordCond, Long monthCond) {

        //TODO. ????????? QueryDsl ????????? ????????????(startDate, endDate ????????? QueryDsl ?????? ????????? ??????????????? ??????)
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
                .orElseThrow(() -> new NoExistMentoringProfileException("?????? ?????? ???????????? ???????????? ????????????."));
    }

    @Transactional
    public void updateProfileImage(Long userId, @Nullable MultipartFile profileImage) {
        Mentor mentor = mentorRepository.findByUserIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistMentorException("?????? ????????? ?????? ????????? ???????????? ????????????."));

        // ????????? ????????? ?????????
        if (profileImage.isEmpty()) {
            mentor.updateProfileImage(null);
        }

        // ????????? ????????? ??????
        if (!profileImage.isEmpty()) {
            String s3SaveFileName = awsS3Service.uploadBucket(profileImage);
            String fileFullPath = "https://" + CLOUD_FRONT_DOMAIN_NAME + "/" + s3SaveFileName;
            mentor.updateProfileImage(fileFullPath);
        }


    }

    @Transactional
    public void updateStatus(Long userId, String status) {
        Mentor mentor = mentorRepository.findByUserIdAndStatus(userId, ACTIVE)
                .orElseThrow(() -> new NoExistMentorException("?????? ????????? ?????? ????????? ???????????? ????????????."));

        if(status.equals("ACTIVE")) {
            mentor.updateOnStatus();
        }

        if(status.equals("INACTIVE")) {

            if(!mentoringRepository.findAllToCheckMentorOff(mentor).isEmpty()) {
                throw new ExistNotFinishMentoringByMentorException("?????? ???????????? ?????? ?????? ????????? ???????????? ??????????????????.");
            }

            mentor.updateOffStatus();
        }
    }
}
