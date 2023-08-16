package com.movieflix.infra.adapters.repositories;


import com.movieflix.domain.Movie;
import com.movieflix.domain.ports.repositories.MovieRepositoryPort;
import com.movieflix.infra.adapters.domain.MovieEntity;
import com.movieflix.infra.adapters.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MovieRepository implements MovieRepositoryPort {

    private final SpringMovieRepository springMovieRepository;

    public MovieRepository(SpringMovieRepository springMovieRepository) {
        this.springMovieRepository = springMovieRepository;
    }

    @Autowired
    private Mapper<MovieEntity, Movie> movieResponseMapper;


    @Override
    public Page<Movie> findMoviesPageFilteredGenreId(Long genreId, Pageable sortedByTitle) {

        return springMovieRepository.findMoviesPageFilteredGenreId(genreId, sortedByTitle)
            .map(movieResponseMapper::map);
    }


    @Override
    public Page<Movie> findAll(Pageable sortedByTitle) {

        return springMovieRepository.findAll(sortedByTitle)
                .map(movieResponseMapper::map);
    }


    @Override
    public Optional<Movie> findById(Long id) {


        return springMovieRepository.findById(id).map(movieResponseMapper::map);
    }

    @Override
    public Movie getOne(Long movieId) {

        MovieEntity movie = springMovieRepository.getOne(movieId);

        return movieResponseMapper.map(movie);
    }
}
