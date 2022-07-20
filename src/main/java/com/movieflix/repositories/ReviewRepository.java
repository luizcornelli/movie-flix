package com.movieflix.repositories;

import com.movieflix.entities.Review;
import com.movieflix.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
