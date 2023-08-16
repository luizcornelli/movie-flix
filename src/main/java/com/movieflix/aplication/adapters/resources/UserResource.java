package com.movieflix.aplication.adapters.resources;

import com.movieflix.domain.dtos.UserDTO;
import com.movieflix.domain.ports.services.UserServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private final UserServicePort userServicePort;

	public UserResource(UserServicePort userServicePort) {
		this.userServicePort = userServicePort;
	}


	@GetMapping(value = "/profile")
	public ResponseEntity<UserDTO> findUserLogged() {
		UserDTO dto = userServicePort.findUserLogged();
		return ResponseEntity.ok().body(dto);
	}
}
