package com.movieflix.aplication.adapters.resources;

import com.movieflix.domain.dtos.GenreDTO;
import com.movieflix.domain.ports.services.GenreServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/genres")
public class GenreResource {

	private final GenreServicePort genreServicePort;

	public GenreResource(GenreServicePort genreServicePort) {
		this.genreServicePort = genreServicePort;
	}

	@GetMapping
	public ResponseEntity<List<GenreDTO>> getGenres() {
		List<GenreDTO> dtos = genreServicePort.getGenres();
		return ResponseEntity.ok().body(dtos);
	}
}
