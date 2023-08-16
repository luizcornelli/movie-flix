package com.movieflix.infra.adapters.repositories;


import com.movieflix.domain.Genre;
import com.movieflix.domain.ports.repositories.GenreRepositoryPort;
import com.movieflix.infra.adapters.domain.GenreEntity;
import com.movieflix.infra.adapters.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreRepository implements GenreRepositoryPort {

    private final SpringGenreRepository springGenreRepository;

    public GenreRepository(SpringGenreRepository springGenreRepository) {
        this.springGenreRepository = springGenreRepository;
    }

    @Autowired
    private Mapper<GenreEntity, Genre> genreResponseMapper;

    @Override
    public List<Genre> findAll() {

        return springGenreRepository.findAll()
                .stream()
                .map(genreResponseMapper::map).collect(Collectors.toList());
    }
}
