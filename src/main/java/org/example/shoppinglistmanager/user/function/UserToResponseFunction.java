package org.example.shoppinglistmanager.user.function;

import org.example.shoppinglistmanager.user.dto.GetUserResponse;
import org.example.shoppinglistmanager.user.entity.User;

import java.util.function.Function;

public class UserToResponseFunction implements Function<User, GetUserResponse> {

    @Override
    public GetUserResponse apply(User user) {
        return GetUserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
