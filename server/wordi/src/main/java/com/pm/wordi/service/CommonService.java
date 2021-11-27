package com.pm.wordi.service;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.repository.MentorRepository;
import com.pm.wordi.domain.mentoring.repository.MentoringRepository;
import com.pm.wordi.domain.review.repository.ReviewRepository;
import com.pm.wordi.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.pm.wordi.controller.dto.CommonDto.*;

@Service
@RequiredArgsConstructor
@Transactional
public class CommonService {

    private final UserRepository userRepository;
    private final MentorRepository mentorRepository;
    private final MentoringRepository mentoringRepository;
    private final ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public MainRes getMain(Long userId) {
        List<ReviewDTO> reviewDTOList = reviewRepository.findTop20ByStatusOrderByIdDesc(BaseStatus.ACTIVE).stream()
                .map(ReviewDTO::new)
                .collect(Collectors.toList());

        // TODO. 멘토링 내역에서 일주일 전 부터 현재까지 멘토 기준으로 멘토링 개수를 실셈하여 내림차순 정렬 + 해당 mentorId를 List로 반환

        List<MentorDTO> mentorDTOList = mentorRepository.searchProfileList().stream()
                .map(MentorDTO::new)
                .collect(Collectors.toList());

        return new MainRes(reviewDTOList, mentorDTOList);

    }
}
