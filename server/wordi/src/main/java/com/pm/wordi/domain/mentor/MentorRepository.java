package com.pm.wordi.domain.mentor;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Long> {

    @EntityGraph(attributePaths = {"mentorKeywordList"})
    Optional<Mentor> findProfileByUserIdAndStatus(Long userId, BaseStatus status);
}
