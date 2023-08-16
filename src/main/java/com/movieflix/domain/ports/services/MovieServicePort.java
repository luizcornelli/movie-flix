package com.movieflix.domain.ports.services;

import com.movieflix.domain.dtos.MovieDTO;
import org.springframework.data.domain.Page;

public interface MovieServicePort {
    MovieDTO getMovie(Long id);

    Page<MovieDTO> getMoviesPageOrderlyTitle(Long genreId);
}
