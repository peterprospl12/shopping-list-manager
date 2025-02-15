package shopping.list.manager.userservice.user.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shopping.list.manager.userservice.user.entity.User;
import shopping.list.manager.userservice.user.repository.api.UserRepository;
import shopping.list.manager.userservice.user.service.api.UserEventPublisher;
import shopping.list.manager.userservice.user.service.api.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserDefaultService implements UserService {

    private final UserRepository userRepository;
    private final UserEventPublisher userEventPublisher;
    private static final Logger logger = LoggerFactory.getLogger(UserDefaultService.class);

    @Autowired
    public UserDefaultService(UserRepository userRepository, UserEventPublisher userEventPublisher) {
        this.userRepository = userRepository;
        this.userEventPublisher = userEventPublisher;
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
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        if (!userRepository.existsById(id)) {
            logger.warn("User with id {} does not exist", id);
            return;
        }
        userRepository.deleteById(id);
        userEventPublisher.notifyUserDeleted(id);
    }

}
