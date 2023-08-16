package com.movieflix.entities;

import com.movieflix.infra.adapters.domain.MovieEntity;
import com.movieflix.infra.adapters.domain.ReviewEntity;
import com.movieflix.infra.adapters.domain.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReviewTests {

	@Test
	public void reviewShouldHaveCorrectStructure() {
	
		ReviewEntity entity = new ReviewEntity();
		entity.setId(1L);
		entity.setText("Text");
		entity.setMovie(new MovieEntity());
		entity.setUser(new UserEntity());
	
		Assertions.assertNotNull(entity.getId());
		Assertions.assertNotNull(entity.getText());
		Assertions.assertNotNull(entity.getMovie());
		Assertions.assertNotNull(entity.getUser());
	}
}
