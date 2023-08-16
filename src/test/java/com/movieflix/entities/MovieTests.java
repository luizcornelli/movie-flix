package com.movieflix.entities;

import com.movieflix.infra.adapters.domain.GenreEntity;
import com.movieflix.infra.adapters.domain.MovieEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieTests {

	@Test
	public void movieShouldHaveCorrectStructure() {
	
		MovieEntity entity = new MovieEntity();
		entity.setId(1L);
		entity.setTitle("Title");
		entity.setSubTitle("Subtitle");
		entity.setSynopsis("Synopsis");
		entity.setYear(2021);
		entity.setImgUrl("https://imgurl.com/img.png");
		entity.setGenre(new GenreEntity());
	
		Assertions.assertNotNull(entity.getId());
		Assertions.assertNotNull(entity.getTitle());
		Assertions.assertNotNull(entity.getSubTitle());
		Assertions.assertNotNull(entity.getSynopsis());
		Assertions.assertNotNull(entity.getYear());
		Assertions.assertNotNull(entity.getImgUrl());
		Assertions.assertNotNull(entity.getGenre());
		Assertions.assertEquals(0, entity.getReviews().size());
	}
}
