package com.movieflix.services;


import com.movieflix.entities.User;
import com.movieflix.repositories.UserRepository;
import com.movieflix.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User userLogged() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(username);
		} catch (Exception e) {
			throw new UnauthorizedException("Invalid user");
		}
	}
}
