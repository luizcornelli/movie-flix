package com.movieflix.aplication.adapters.resources;

import com.movieflix.domain.dtos.ReviewDTO;
import com.movieflix.domain.ports.services.ReviewServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewResource {

	private final ReviewServicePort reviewServicePort;

	public ReviewResource(ReviewServicePort reviewServicePort) {
		this.reviewServicePort = reviewServicePort;
	}

	@PostMapping
	public ResponseEntity<ReviewDTO> insertReview(@RequestBody ReviewDTO reviewDTO) {
		ReviewDTO dto = reviewServicePort.insertReview(reviewDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
}
