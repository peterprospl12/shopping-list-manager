package shopping.list.manager.productservice.user.service.impl;

import org.springframework.stereotype.Service;
import shopping.list.manager.productservice.user.entity.User;
import shopping.list.manager.productservice.user.repository.api.UserRepository;
import shopping.list.manager.productservice.user.service.api.UserService;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserDefaultService implements UserService {

    private final UserRepository repository;

    public UserDefaultService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
