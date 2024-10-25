package org.example.shoppinglistmanager.user.function;

import org.example.shoppinglistmanager.user.dto.PutPasswordRequest;
import org.example.shoppinglistmanager.user.dto.PutUserRequest;
import org.example.shoppinglistmanager.user.entity.User;

import java.util.UUID;
import java.util.function.BiFunction;

public class UpdateUserPasswordWithRequestFunction implements BiFunction<User, PutPasswordRequest, User> {

    @Override
    public User apply(User entity, PutPasswordRequest request) {
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .email(entity.getEmail())
                .birthDate(entity.getBirthDate())
                .password(request.getPassword())
                .build();
    }
}
