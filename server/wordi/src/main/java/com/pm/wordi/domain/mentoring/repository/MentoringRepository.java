package com.pm.wordi.domain.mentoring.repository;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.mentoring.entity.Mentoring;
import com.pm.wordi.domain.user.entity.User;
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

    @Query("select mt from Mentoring mt where mt.mentor = :mentor and mt.status = 'ACTIVE' " +
            "and (mt.mentoringStatus = '승인대기' or mt.mentoringStatus = '예약확정') ")
    List<Mentoring> findAllToCheckMentorOff(@Param("mentor") Mentor mentor);

    @Query("select mt from Mentoring mt where mt.user = :user and mt.status = 'ACTIVE' " +
            "and (mt.mentoringStatus = '승인대기' or mt.mentoringStatus = '예약확정') ")
    List<Mentoring> findAllToCheckUserDelete(@Param("user") User user);


}
