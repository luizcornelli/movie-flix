package com.movieflix.domain.adapters.services;

import com.movieflix.domain.Movie;
import com.movieflix.domain.adapters.services.exceptions.ResourceNotFoundException;
import com.movieflix.domain.dtos.MovieDTO;
import com.movieflix.domain.ports.repositories.MovieRepositoryPort;
import com.movieflix.domain.ports.services.MovieServicePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public class MovieServiceImpl implements MovieServicePort {

    private final MovieRepositoryPort movieRepositoryPort;

    public MovieServiceImpl(MovieRepositoryPort movieRepositoryPort) {
        this.movieRepositoryPort = movieRepositoryPort;
    }


    @Override
    public MovieDTO getMovie(Long id) {

        Movie movie = movieRepositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found."));

        return new MovieDTO(movie);
    }

    @Override
    public Page<MovieDTO> getMoviesPageOrderlyTitle(Long genreId) {

        Pageable sortedByTitle =
                PageRequest.of(0, 5, Sort.by("title"));

        if(genreId != null && genreId > 0){
            return movieRepositoryPort
                    .findMoviesPageFilteredGenreId(genreId, sortedByTitle).map(MovieDTO::new);
        }
        return movieRepositoryPort.findAll(sortedByTitle).map(MovieDTO::new);
    }
}
