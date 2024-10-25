package org.example.shoppinglistmanager.user.service.api;

import org.example.shoppinglistmanager.user.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<User> find(UUID id);
    Optional<User> findByEmail(String email);

    void create(User user);
    void update(User user);
    void delete(UUID id);
}
