package com.movieflix.infra.adapters.mappers;

import com.movieflix.domain.Genre;
import com.movieflix.domain.Review;
import com.movieflix.infra.adapters.domain.GenreEntity;
import com.movieflix.infra.adapters.domain.MovieEntity;
import com.movieflix.infra.adapters.domain.ReviewEntity;
import com.movieflix.infra.adapters.domain.UserEntity;
import org.springframework.stereotype.Component;
@Component
public class ReviewRequestMapper implements Mapper<Review, ReviewEntity> {

    @Override
    public ReviewEntity map(Review review) {

        if (review == null) {
            return null;
        }

        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setId(review.getId());
        reviewEntity.setText(review.getText());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(review.getUser().getId());
        userEntity.setName(review.getUser().getName());
        userEntity.setEmail(review.getUser().getEmail());
        userEntity.setPassword(review.getUser().getPassword());
        reviewEntity.setUser(userEntity);

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(review.getMovie().getId());
        movieEntity.setTitle(review.getMovie().getTitle());
        movieEntity.setSubTitle(review.getMovie().getSubTitle());
        movieEntity.setYear(review.getMovie().getYear());
        movieEntity.setImgUrl(review.getMovie().getImgUrl());
        movieEntity.setSynopsis(review.getMovie().getSynopsis());

        reviewEntity.setMovie(movieEntity);
        return reviewEntity;
    }

}
