package com.pm.wordi.domain.mentor.repository;

import com.pm.wordi.domain.mentor.entity.Mentor;
import com.pm.wordi.domain.mentor.entity.MentorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorScheduleRepository extends JpaRepository<MentorSchedule, Long> {
    void deleteByMentor(Mentor mentor);
}
