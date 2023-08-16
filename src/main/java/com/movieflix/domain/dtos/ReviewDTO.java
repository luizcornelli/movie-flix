package com.movieflix.domain.dtos;



import com.movieflix.domain.Review;
import com.movieflix.domain.User;

import java.io.Serializable;

public class ReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String text;
	private Long movieId;

	private User user;

	public ReviewDTO() {
	}

	public ReviewDTO(Long id, String text, Long movieId) {
		this.id = id;
		this.text = text;
		this.movieId = movieId;
	}

	public ReviewDTO(Review entity) {
		this.id = entity.getId();
		this.text = entity.getText();
		this.movieId = entity.getMovie().getId();
		this.user = entity.getUser();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
