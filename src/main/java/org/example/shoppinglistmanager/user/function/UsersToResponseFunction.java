package org.example.shoppinglistmanager.user.function;

import org.example.shoppinglistmanager.user.dto.GetUsersResponse;
import org.example.shoppinglistmanager.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class UsersToResponseFunction implements Function<List<User>, GetUsersResponse> {

    @Override
    public GetUsersResponse apply(List<User> users) {
        return GetUsersResponse.builder()
                .users(users.stream()
                        .map(user -> GetUsersResponse.User.builder()
                                .id(user.getId())
                                .email(user.getEmail())
                                .build())
                        .toList())
                .build();
    }
}
