package org.example.shoppinglistmanager.user.function;

import org.example.shoppinglistmanager.user.dto.PutUserRequest;
import org.example.shoppinglistmanager.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToUserFunction implements BiFunction<UUID, PutUserRequest, User> {

    @Override
    public User apply(UUID id, PutUserRequest request) {
        return User.builder()
                .id(id)
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .birthDate(request.getBirthDate())
                .password(request.getPassword())
                .build();
    }
}
