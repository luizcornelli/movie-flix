package com.movieflix.repositories;

import com.movieflix.entities.Movie;
import com.movieflix.entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT obj FROM Movie obj WHERE obj.genre.id = :genreId")
    Page<Movie> findMoviesPageFilteredGenreId(Long genreId, Pageable sortedByTitle);
}
