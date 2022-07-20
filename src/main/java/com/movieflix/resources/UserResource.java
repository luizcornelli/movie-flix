package com.movieflix.resources;

import com.movieflix.dto.UserDTO;
import com.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/profile")
	public ResponseEntity<UserDTO> findUserLogged() {
		UserDTO dto = service.findUserLogged();
		return ResponseEntity.ok().body(dto);
	}
}
