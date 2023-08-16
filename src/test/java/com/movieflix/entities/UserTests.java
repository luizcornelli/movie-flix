package com.movieflix.entities;

import com.movieflix.infra.adapters.domain.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTests {

	@Test
	public void userShouldHaveCorrectStructure() {
	
		UserEntity entity = new UserEntity();
		entity.setId(1L);
		entity.setName("Name");
		entity.setEmail("email@gmail.com");
		entity.setPassword("password");
	
		Assertions.assertNotNull(entity.getId());
		Assertions.assertNotNull(entity.getName());
		Assertions.assertNotNull(entity.getEmail());
		Assertions.assertNotNull(entity.getPassword());
		Assertions.assertEquals(0, entity.getRoles().size());
		Assertions.assertEquals(0, entity.getReviews().size());
	}
}
