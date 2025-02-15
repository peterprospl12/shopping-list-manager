package shopping.list.manager.userservice.user.service.api;


import shopping.list.manager.userservice.user.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> findAll();
    Optional<User> find(UUID id);
    Optional<User> findByEmail(String email);


    void create(User user);
    void update(User user);
    void delete(UUID id);
}
