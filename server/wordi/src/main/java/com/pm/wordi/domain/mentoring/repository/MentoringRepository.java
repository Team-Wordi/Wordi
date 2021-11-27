package com.pm.wordi.domain.mentoring.repository;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentoring.entity.Mentoring;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MentoringRepository extends JpaRepository<Mentoring, Long> {

    @EntityGraph(attributePaths = {"payment"})
    List<Mentoring> findAllByMentorIdAndStatus(Long mentorId, BaseStatus baseStatus);

    @EntityGraph(attributePaths = {"payment", "mentor"})
    List<Mentoring> findAllByUserIdAndStatus(Long userId, BaseStatus baseStatus);

    @EntityGraph(attributePaths = {"payment"})
    Optional<Mentoring> findByIdAndStatus(Long mentoringId, BaseStatus baseStatus);


}