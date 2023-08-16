package com.movieflix.domain.ports.repositories;

import com.movieflix.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MovieRepositoryPort {
    Page<Movie> findMoviesPageFilteredGenreId(Long genreId, Pageable sortedByTitle);

    Page<Movie> findAll(Pageable sortedByTitle);

    Optional<Movie> findById(Long id);

    Movie getOne(Long movieId);
}
