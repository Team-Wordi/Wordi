package com.pm.wordi.domain.mentor;

import java.util.List;


public interface MentorRepositoryCustom {
    List<Mentor> searchProfileList(String nation, String keyword);
}
