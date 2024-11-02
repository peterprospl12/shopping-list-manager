package shopping.list.manager.userservice.user.function;


import org.springframework.stereotype.Component;
import shopping.list.manager.userservice.user.dto.GetUsersResponse;
import shopping.list.manager.userservice.user.entity.User;

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
