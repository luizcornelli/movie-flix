package com.movieflix.domain.ports.services;

import com.movieflix.domain.dtos.UserDTO;

public interface UserServicePort {
    UserDTO findUserLogged();
}
