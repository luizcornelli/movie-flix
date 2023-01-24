package com.movieflix.resources;

import com.movieflix.dto.ReviewDTO;
import com.movieflix.dto.UserDTO;
import com.movieflix.services.ReviewService;
import com.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewResource {

	@Autowired
	private ReviewService service;
	
	@PostMapping
	public ResponseEntity<ReviewDTO> insertReview(@RequestBody ReviewDTO reviewDTO) {
		ReviewDTO dto = service.insertReview(reviewDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
}
