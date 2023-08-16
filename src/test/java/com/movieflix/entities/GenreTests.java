package com.movieflix.entities;

import com.movieflix.infra.adapters.domain.GenreEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenreTests {

	@Test
	public void genreShouldHaveCorrectStructure() {
	
		GenreEntity entity = new GenreEntity();
		entity.setId(1L);
		entity.setName("Maria");
	
		Assertions.assertNotNull(entity.getId());
		Assertions.assertNotNull(entity.getName());
		Assertions.assertEquals(0, entity.getMovies().size());
	}
}
