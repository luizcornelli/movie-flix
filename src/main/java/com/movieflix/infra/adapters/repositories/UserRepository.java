package com.movieflix.infra.adapters.repositories;

import com.movieflix.domain.User;
import com.movieflix.domain.adapters.services.exceptions.UnauthorizedException;
import com.movieflix.domain.ports.repositories.UserRepositoryPort;
import com.movieflix.infra.adapters.domain.UserEntity;
import com.movieflix.infra.adapters.mappers.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements UserRepositoryPort, UserDetailsService {

    private final SpringUserRepository springUserRepository;

    public UserRepository(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Autowired
    private Mapper<UserEntity, User> userResponseMapper;

    @Override
    public User findByEmail(String username) {

        return userResponseMapper.map(springUserRepository.findByEmail(username));
    }

    @Override
    public User findUserLogged() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userResponseMapper.map(springUserRepository.findByEmail(username));
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userResponseMapper.map(springUserRepository.findByEmail(username));
        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }
        return user;
    }
}
