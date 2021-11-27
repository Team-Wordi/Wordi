package com.pm.wordi.domain.mentor.repository;

import com.pm.wordi.domain.mentor.entity.Mentor;

import java.util.List;


public interface MentorRepositoryCustom {
    List<Mentor> searchProfileList(String nation, String keyword);
}
