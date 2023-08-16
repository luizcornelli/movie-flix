package com.movieflix.infra.adapters.repositories;

import com.movieflix.infra.adapters.domain.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringReviewRepository extends JpaRepository<ReviewEntity, Long> {

}
