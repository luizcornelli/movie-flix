package com.movieflix.domain.adapters.services;

import com.movieflix.domain.Genre;
import com.movieflix.domain.dtos.GenreDTO;
import com.movieflix.domain.ports.repositories.GenreRepositoryPort;
import com.movieflix.domain.ports.services.GenreServicePort;

import java.util.List;
import java.util.stream.Collectors;


public class GenreServiceImpl implements GenreServicePort {

    private final GenreRepositoryPort genreRepositoryPort;

    public GenreServiceImpl(GenreRepositoryPort genreRepositoryPort) {
        this.genreRepositoryPort = genreRepositoryPort;
    }

    public List<GenreDTO> getGenres() {

        List<Genre> genre = genreRepositoryPort.findAll();

        return genre.stream().map(GenreDTO::new).collect(Collectors.toList());
    }
}
