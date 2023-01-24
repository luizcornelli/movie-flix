package com.movieflix.services;

import com.movieflix.dto.GenreDTO;
import com.movieflix.dto.MovieDTO;
import com.movieflix.entities.Genre;
import com.movieflix.entities.Movie;
import com.movieflix.repositories.GenreRepository;
import com.movieflix.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<GenreDTO> getGenres() {

        List<Genre> genre = genreRepository.findAll();

        return genre.stream().map(GenreDTO::new).collect(Collectors.toList());
    }
}
