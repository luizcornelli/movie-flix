package com.movieflix.infra.adapters.repositories;

import com.movieflix.domain.Review;
import com.movieflix.domain.ports.repositories.ReviewRepositoryPort;
import com.movieflix.infra.adapters.domain.ReviewEntity;
import com.movieflix.infra.adapters.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ReviewRepository implements ReviewRepositoryPort {

    private final SpringReviewRepository springReviewRepository;

    public ReviewRepository(SpringReviewRepository springReviewRepository) {
        this.springReviewRepository = springReviewRepository;
    }

    @Autowired
    private Mapper<Review, ReviewEntity> reviewRequestMapper;

    @Autowired
    private Mapper<ReviewEntity, Review> reviewResponseMapper;

    @Transactional
    @Override
    public Review save(Review newReview) {

        ReviewEntity reviewEntity = reviewRequestMapper.map(newReview);
        springReviewRepository.save(reviewEntity);

        return reviewResponseMapper.map(springReviewRepository.save(reviewEntity));
    }
}
