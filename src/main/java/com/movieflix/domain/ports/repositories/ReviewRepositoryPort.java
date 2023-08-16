package com.movieflix.domain.ports.repositories;


import com.movieflix.domain.Review;

public interface ReviewRepositoryPort {
    Review save(Review newReview);
}
