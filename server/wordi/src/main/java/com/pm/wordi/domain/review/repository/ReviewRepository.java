package com.pm.wordi.domain.review.repository;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.review.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @EntityGraph(attributePaths = {"mentor"})
    List<Review> findTop20ByStatusOrderByIdDesc(BaseStatus status);

    @EntityGraph(attributePaths = {"user", "mentor"})
    List<Review> findAllByUserIdAndStatus(Long userId, BaseStatus status);

    @EntityGraph(attributePaths = {"user", "mentor"})
    List<Review> findAllByMentorIdAndStatus(Long mentorId, BaseStatus status);

    @EntityGraph(attributePaths = {"user", "mentor"})
    Optional<Review> findByIdAndStatus(Long reviewId, BaseStatus status);
}
