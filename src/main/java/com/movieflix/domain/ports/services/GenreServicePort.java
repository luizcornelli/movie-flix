package com.movieflix.domain.ports.services;

import com.movieflix.domain.dtos.GenreDTO;

import java.util.List;

public interface GenreServicePort {
    List<GenreDTO> getGenres();
}
