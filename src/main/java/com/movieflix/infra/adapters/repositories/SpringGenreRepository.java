package com.movieflix.infra.adapters.repositories;

import com.movieflix.infra.adapters.domain.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringGenreRepository extends JpaRepository<GenreEntity, Long> {

}
