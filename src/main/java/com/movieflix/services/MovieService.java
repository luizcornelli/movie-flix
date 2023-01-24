package com.movieflix.services;

import com.movieflix.dto.MovieDTO;
import com.movieflix.dto.ReviewDTO;
import com.movieflix.dto.UserDTO;
import com.movieflix.entities.Movie;
import com.movieflix.entities.Review;
import com.movieflix.entities.User;
import com.movieflix.repositories.MovieRepository;
import com.movieflix.repositories.ReviewRepository;
import com.movieflix.services.exceptions.ForbiddenException;
import com.movieflix.services.exceptions.ResourceNotFoundException;
import com.movieflix.services.exceptions.UnproccessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public MovieDTO getMovie(Long movieId) {

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
        return new MovieDTO(movie);
    }

    @Transactional(readOnly = true)
    public Page<MovieDTO> getMoviesPageOrderlyTitle(Long genreId) {

        Pageable sortedByTitle =
                PageRequest.of(0, 5, Sort.by("title"));

        if(genreId != null && genreId > 0){
            return movieRepository
                    .findMoviesPageFilteredGenreId(genreId, sortedByTitle).map(MovieDTO::new);
        }

        return movieRepository.findAll(sortedByTitle).map(MovieDTO::new);
    }

}
