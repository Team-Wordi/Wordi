package com.pm.wordi.domain.mentoring;

import com.pm.wordi.domain.BaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentoringRepository extends JpaRepository<Mentoring, Long> {

    List<Mentoring> findAllByMentorIdAndStatus(Long mentorId, BaseStatus baseStatus);
}
