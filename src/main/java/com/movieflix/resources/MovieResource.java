package com.movieflix.resources;

import com.movieflix.dto.MovieDTO;
import com.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

	@Autowired
	private MovieService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> getMovie(@PathVariable Long id) {
		MovieDTO dto = service.getMovie(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping
	public ResponseEntity<Page<MovieDTO>> getMoviesPageOrderlyTitleOrFilteredGenre(@RequestParam(value = "genreId", required = false) Long genreId) {

		Page<MovieDTO> page = service.getMoviesPageOrderlyTitle(genreId);
		return ResponseEntity.ok().body(page);
	}
}
