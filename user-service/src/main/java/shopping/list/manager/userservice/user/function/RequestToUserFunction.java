package shopping.list.manager.userservice.user.function;


import org.springframework.stereotype.Component;
import shopping.list.manager.userservice.user.dto.PutUserRequest;
import shopping.list.manager.userservice.user.entity.User;

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
