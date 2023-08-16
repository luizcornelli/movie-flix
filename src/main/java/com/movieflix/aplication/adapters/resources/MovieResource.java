package com.movieflix.aplication.adapters.resources;

import com.movieflix.domain.dtos.MovieDTO;
import com.movieflix.domain.ports.services.MovieServicePort;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

	private final MovieServicePort movieServicePort;

	public MovieResource(MovieServicePort movieServicePort) {
		this.movieServicePort = movieServicePort;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> getMovie(@PathVariable Long id) {
		MovieDTO dto = movieServicePort.getMovie(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping
	public ResponseEntity<Page<MovieDTO>> getMoviesPageOrderlyTitleOrFilteredGenre(@RequestParam(value = "genreId", required = false) Long genreId) {

		Page<MovieDTO> page = movieServicePort.getMoviesPageOrderlyTitle(genreId);
		return ResponseEntity.ok().body(page);
	}
}
