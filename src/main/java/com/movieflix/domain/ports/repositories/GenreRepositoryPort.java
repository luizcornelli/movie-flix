package com.movieflix.domain.ports.repositories;

import com.movieflix.domain.Genre;

import java.util.List;

public interface GenreRepositoryPort {
    List<Genre> findAll();
}
