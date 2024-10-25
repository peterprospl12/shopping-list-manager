package org.example.shoppinglistmanager.user.function;

import org.example.shoppinglistmanager.user.dto.PatchUserRequest;
import org.example.shoppinglistmanager.user.dto.PutUserRequest;
import org.example.shoppinglistmanager.user.entity.User;

import java.util.UUID;
import java.util.function.BiFunction;

public class UpdateUserWithRequestFunction implements BiFunction<User, PatchUserRequest, User> {

    @Override
    public User apply(User entity, PatchUserRequest request) {
        return User.builder()
                .id(entity.getId())
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .birthDate(request.getBirthDate())
                .password(entity.getPassword())
                .build();
    }
}
