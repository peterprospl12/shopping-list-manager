package org.example.shoppinglistmanager.service.api;

import org.example.shoppinglistmanager.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<User> find(UUID id);
    Optional<User> findByUsername(String username);

    void create(User user);
    void update(User user);
    void delete(UUID id);
}
