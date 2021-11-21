package com.pm.wordi.domain.mentor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorKeywordRepository extends JpaRepository<MentorKeyword, Long> {
    void deleteByMentor(Mentor mentor);
}
