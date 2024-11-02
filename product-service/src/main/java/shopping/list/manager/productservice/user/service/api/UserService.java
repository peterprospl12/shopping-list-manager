package shopping.list.manager.productservice.user.service.api;

import shopping.list.manager.productservice.user.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<User> find(UUID id);

    void create(User user);

    void delete(UUID id);
}
