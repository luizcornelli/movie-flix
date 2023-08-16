package com.movieflix.domain.ports.services;

import com.movieflix.domain.dtos.ReviewDTO;

public interface ReviewServicePort {
    ReviewDTO insertReview(ReviewDTO reviewDTO);
}
