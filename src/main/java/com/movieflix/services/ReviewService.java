package com.movieflix.services;

import com.movieflix.dto.ReviewDTO;
import com.movieflix.dto.UserDTO;
import com.movieflix.entities.Review;
import com.movieflix.entities.User;
import com.movieflix.repositories.MovieRepository;
import com.movieflix.repositories.ReviewRepository;
import com.movieflix.services.exceptions.ForbiddenException;
import com.movieflix.services.exceptions.UnproccessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public ReviewDTO insertReview(ReviewDTO reviewDTO) {

        Review newReview = new Review();

        newReview.setMovie(movieRepository.getOne(reviewDTO.getMovieId()));

        if(reviewDTO.getText().isBlank()){
            throw new UnproccessableEntityException("Invalid Data review.");
        }

        newReview.setText(reviewDTO.getText());

        UserDTO userLogged = userService.findUserLogged();

       if(userLogged.hasHole("ROLE_VISITOR")){
           throw new ForbiddenException("Invalid User resource.");
       }

        User user = new User();
        user.setEmail(userLogged.getEmail());
        user.setId(userLogged.getId());
        user.setName(userLogged.getName());

        newReview.setUser(user);

        newReview = repository.save(newReview);

        return new ReviewDTO(newReview);
    }
}
