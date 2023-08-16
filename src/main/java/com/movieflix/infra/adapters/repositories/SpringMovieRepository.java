package com.movieflix.infra.adapters.repositories;

import com.movieflix.infra.adapters.domain.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringMovieRepository extends JpaRepository<MovieEntity, Long> {
    @Query("SELECT obj FROM MovieEntity obj WHERE obj.genre.id = :genreId")
    Page<MovieEntity> findMoviesPageFilteredGenreId(Long genreId, Pageable sortedByTitle);
}
