package com.movieflix.domain.adapters.services;

import com.movieflix.domain.Review;
import com.movieflix.domain.User;
import com.movieflix.domain.adapters.services.exceptions.ForbiddenException;
import com.movieflix.domain.adapters.services.exceptions.UnproccessableEntityException;
import com.movieflix.domain.dtos.ReviewDTO;
import com.movieflix.domain.dtos.UserDTO;
import com.movieflix.domain.ports.repositories.MovieRepositoryPort;
import com.movieflix.domain.ports.repositories.ReviewRepositoryPort;
import com.movieflix.domain.ports.repositories.UserRepositoryPort;
import com.movieflix.domain.ports.services.ReviewServicePort;


public class ReviewServiceImpl implements ReviewServicePort {

    private final ReviewRepositoryPort reviewRepositoryPort;

    private final MovieRepositoryPort movieRepositoryPort;

    private final UserRepositoryPort userRepositoryPort;

    public ReviewServiceImpl(ReviewRepositoryPort reviewRepositoryPort,
                             MovieRepositoryPort movieRepositoryPort,
                             UserRepositoryPort userRepositoryPort) {
        this.reviewRepositoryPort = reviewRepositoryPort;
        this.movieRepositoryPort = movieRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public ReviewDTO insertReview(ReviewDTO reviewDTO) {

        Review newReview = new Review();

        newReview.setMovie(movieRepositoryPort.getOne(reviewDTO.getMovieId()));

        if(reviewDTO.getText().isBlank()){
            throw new UnproccessableEntityException("Invalid Data review.");
        }

        newReview.setText(reviewDTO.getText());

        UserDTO userLogged = new UserDTO(userRepositoryPort.findUserLogged());

        if(userLogged.hasHole("ROLE_VISITOR")){
            throw new ForbiddenException("Invalid User resource.");
        }

        User user = new User();
        user.setEmail(userLogged.getEmail());
        user.setId(userLogged.getId());
        user.setName(userLogged.getName());

        newReview.setUser(user);

        newReview = reviewRepositoryPort.save(newReview);

        return new ReviewDTO(newReview);
    }
}
