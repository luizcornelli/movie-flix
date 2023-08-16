package com.movieflix.domain.adapters.services;

import com.movieflix.domain.User;
import com.movieflix.domain.dtos.UserDTO;
import com.movieflix.domain.ports.repositories.UserRepositoryPort;
import com.movieflix.domain.ports.services.UserServicePort;
import com.movieflix.domain.adapters.services.exceptions.UnauthorizedException;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserServiceImpl implements UserServicePort {

    private final UserRepositoryPort userRepositoryPort;

    public UserServiceImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }


    @Override
    public UserDTO findUserLogged() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();

            User user = userRepositoryPort.findByEmail(username);

            return new UserDTO(user);

        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }
}
