package com.pm.wordi.domain.user.repository;

import com.pm.wordi.domain.user.entity.User;
import com.pm.wordi.domain.user.entity.UserKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserKeywordRepository extends JpaRepository<UserKeyword, Long> {

    void deleteByUser(User user);
}
