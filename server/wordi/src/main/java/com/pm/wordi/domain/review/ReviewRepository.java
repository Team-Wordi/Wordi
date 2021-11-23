package com.pm.wordi.domain.review;

import com.pm.wordi.domain.BaseStatus;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @EntityGraph(attributePaths = {"mentor"})
    List<Review> findTop20ByStatusOrderByIdDesc(BaseStatus status);
}
