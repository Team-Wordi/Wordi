package com.pm.wordi.domain.mentor.repository;

import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.mentor.entity.MentorKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorKeywordRepository extends JpaRepository<MentorKeyword, Long> {
    void deleteByMentor(Mentor mentor);
}
