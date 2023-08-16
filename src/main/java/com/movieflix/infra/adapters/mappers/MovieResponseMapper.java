package com.movieflix.infra.adapters.mappers;

import com.movieflix.domain.Genre;
import com.movieflix.domain.Movie;
import com.movieflix.infra.adapters.domain.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieResponseMapper implements Mapper<MovieEntity, Movie> {

    @Override
    public com.movieflix.domain.Movie map(MovieEntity movie) {

        if (movie == null) {
            return null;
        }

        Movie movieResponse = new Movie();
        movieResponse.setId(movie.getId());
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setSubTitle(movie.getSubTitle());
        movieResponse.setYear(movie.getYear());
        movieResponse.setImgUrl(movie.getImgUrl());
        movieResponse.setSynopsis(movie.getSynopsis());

        Genre genreResponse = new Genre();
        genreResponse.setId(movie.getGenre().getId());
        genreResponse.setName(movie.getGenre().getName());

        movieResponse.setGenre(genreResponse);

        return movieResponse;
    }

}
