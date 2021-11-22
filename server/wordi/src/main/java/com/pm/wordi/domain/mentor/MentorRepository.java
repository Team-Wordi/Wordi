package com.pm.wordi.domain.mentor;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Long> {

    Long countByUser(User user);

    @EntityGraph(attributePaths = {"mentorKeywordList"})
    Optional<Mentor> findByUserIdAndStatus(Long userId, BaseStatus status);

    @EntityGraph(attributePaths = {"user"})
    @Query("select m from Mentor m where m.status = 'ACTIVE' order by m.id desc")
    List<Mentor> searchProfileList();

    @EntityGraph(attributePaths = {"mentorScheduleList"})
    Optional<Mentor> findByIdAndStatus(Long mentorId, BaseStatus status);

    @EntityGraph(attributePaths = {"user"})
    Optional<Mentor> findFetchUserByIdAndStatus(Long mentorId, BaseStatus status);


}
