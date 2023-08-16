package com.movieflix.domain.ports.repositories;

import com.movieflix.domain.User;

public interface UserRepositoryPort {
    User findByEmail(String username);

    User findUserLogged();
}
