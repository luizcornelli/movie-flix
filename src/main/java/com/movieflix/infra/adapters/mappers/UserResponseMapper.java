package com.movieflix.infra.adapters.mappers;

import com.movieflix.domain.Role;
import com.movieflix.domain.User;
import com.movieflix.infra.adapters.domain.UserEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserResponseMapper implements Mapper<UserEntity, User> {

    @Override
    public User map(UserEntity userEntity) {

        if (userEntity == null) {
            return null;
        }

        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());

        user.getRoles().addAll(userEntity.getRoles()
                .stream().map(x -> new Role(x.getId(), x.getAuthority())).collect(Collectors.toList()));
        return user;
    }

}
