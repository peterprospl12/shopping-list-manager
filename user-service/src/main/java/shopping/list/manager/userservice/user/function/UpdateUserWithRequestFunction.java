package shopping.list.manager.userservice.user.function;


import org.springframework.stereotype.Component;
import shopping.list.manager.userservice.user.dto.PatchUserRequest;
import shopping.list.manager.userservice.user.entity.User;

import java.util.function.BiFunction;

@Component
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
