package com.movieflix.resources;

import com.movieflix.dto.GenreDTO;
import com.movieflix.dto.MovieDTO;
import com.movieflix.entities.Genre;
import com.movieflix.services.GenreService;
import com.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/genres")
public class GenreResource {

	@Autowired
	private GenreService service;

	@GetMapping
	public ResponseEntity<List<GenreDTO>> getGenres() {
		List<GenreDTO> dtos = service.getGenres();
		return ResponseEntity.ok().body(dtos);
	}
}
