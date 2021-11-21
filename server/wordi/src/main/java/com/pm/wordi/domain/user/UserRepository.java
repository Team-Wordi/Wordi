package com.pm.wordi.domain.user;

import com.pm.wordi.domain.BaseStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndStatus(String email, BaseStatus status);

    boolean existsByEmailAndStatus(String email, BaseStatus status);

    boolean existsByNicknameAndStatus(String nickname, BaseStatus status);

    Optional<User> findByIdAndStatus(Long id, BaseStatus status);

    @EntityGraph(attributePaths = {"userKeywordList"})
    Optional<User> findFetchByIdAndStatus(Long id, BaseStatus status);

}
