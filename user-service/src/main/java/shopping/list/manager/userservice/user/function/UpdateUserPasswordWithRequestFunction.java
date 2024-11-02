package shopping.list.manager.userservice.user.function;


import org.springframework.stereotype.Component;
import shopping.list.manager.userservice.user.dto.PutPasswordRequest;
import shopping.list.manager.userservice.user.entity.User;

import java.util.function.BiFunction;

@Component
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
