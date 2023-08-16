package com.movieflix.entities;

import com.movieflix.infra.adapters.domain.RoleEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoleTests {

	@Test
	public void roleShouldHaveCorrectStructure() {
	
		RoleEntity entity = new RoleEntity();
		entity.setId(1L);
		entity.setAuthority("ROLE_MEMBER");
	
		Assertions.assertNotNull(entity.getId());
		Assertions.assertNotNull(entity.getAuthority());
	}
}
