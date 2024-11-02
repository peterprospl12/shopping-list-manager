package shopping.list.manager.userservice.user.function;


import org.springframework.stereotype.Component;
import shopping.list.manager.userservice.user.dto.GetUserResponse;
import shopping.list.manager.userservice.user.entity.User;

import java.util.function.Function;

@Component
public class UserToResponseFunction implements Function<User, GetUserResponse> {

    @Override
    public GetUserResponse apply(User user) {
        return GetUserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .surname(user.getSurname())
                .birthDate(user.getBirthDate())
                .build();
    }
}
