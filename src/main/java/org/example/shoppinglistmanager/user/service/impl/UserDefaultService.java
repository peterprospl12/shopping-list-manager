package org.example.shoppinglistmanager.user.service.impl;

import org.example.shoppinglistmanager.user.entity.User;
import org.example.shoppinglistmanager.user.repository.api.UserRepository;
import org.example.shoppinglistmanager.user.service.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserDefaultService implements UserService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserDefaultService.class);

    @Autowired
    public UserDefaultService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> find(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
        logger.info("User with email: {} has been created.", user.getEmail());
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

}
