package com.movieflix.infra.adapters.repositories;

import com.movieflix.infra.adapters.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringUserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
}
