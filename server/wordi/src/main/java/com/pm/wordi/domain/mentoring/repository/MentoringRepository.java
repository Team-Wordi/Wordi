package com.pm.wordi.domain.mentoring.repository;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.mentoring.entity.Mentoring;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MentoringRepository extends JpaRepository<Mentoring, Long> {

    @EntityGraph(attributePaths = {"payment"})
    List<Mentoring> findAllByMentorIdAndStatus(Long mentorId, BaseStatus baseStatus);

    @EntityGraph(attributePaths = {"payment", "mentor"})
    List<Mentoring> findAllByUserIdAndStatus(Long userId, BaseStatus baseStatus);

    @EntityGraph(attributePaths = {"payment"})
    Optional<Mentoring> findByIdAndStatus(Long mentoringId, BaseStatus baseStatus);

    @Query("select mt.mentor from Mentoring mt where mt.id = :id and mt.status = 'ACTIVE'")
    Optional<Mentor> findMentorById(@Param("id") Long mentoringId);


}
