package com.movieflix.infra.adapters.mappers;

import com.movieflix.domain.Movie;
import com.movieflix.domain.Review;
import com.movieflix.domain.User;
import com.movieflix.infra.adapters.domain.ReviewEntity;
import org.springframework.stereotype.Component;
@Component
public class ReviewResponseMapper implements Mapper<ReviewEntity, Review> {

    @Override
    public Review map(ReviewEntity reviewEntity) {

        if (reviewEntity == null) {
            return null;
        }

        Review review = new Review();
        review.setId(reviewEntity.getId());
        review.setText(reviewEntity.getText());

        User user = new User();
        user.setId(reviewEntity.getUser().getId());
        user.setName(reviewEntity.getUser().getName());
        user.setEmail(reviewEntity.getUser().getEmail());
        user.setPassword(reviewEntity.getUser().getPassword());
        review.setUser(user);

        Movie movie = new Movie();
        movie.setId(reviewEntity.getMovie().getId());
        movie.setTitle(reviewEntity.getMovie().getTitle());
        movie.setSubTitle(reviewEntity.getMovie().getSubTitle());
        movie.setYear(reviewEntity.getMovie().getYear());
        movie.setImgUrl(reviewEntity.getMovie().getImgUrl());
        movie.setSynopsis(reviewEntity.getMovie().getSynopsis());

        review.setMovie(movie);

        return review;
    }

}
