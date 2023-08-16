package com.movieflix.infra.adapters.mappers;

import com.movieflix.domain.Genre;
import com.movieflix.infra.adapters.domain.GenreEntity;
import org.springframework.stereotype.Component;

@Component
public class GenreResponseMapper implements Mapper<GenreEntity, Genre> {

    @Override
    public Genre map(GenreEntity genre) {

        if (genre == null) {
            return null;
        }

        Genre genreResponse = new Genre();
        genreResponse.setId(genre.getId());
        genreResponse.setName(genre.getName());

        return genreResponse;
    }

}
