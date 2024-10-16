package org.example.shoppinglistmanager.service.impl;

import org.example.shoppinglistmanager.entity.ShoppingList;
import org.example.shoppinglistmanager.entity.User;
import org.example.shoppinglistmanager.entity.enums.Status;
import org.example.shoppinglistmanager.repository.api.ShoppingListRepository;
import org.example.shoppinglistmanager.repository.api.UserRepository;
import org.example.shoppinglistmanager.service.api.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShoppingListDefaultService implements ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final UserRepository userRepository;

    @Autowired
    public ShoppingListDefaultService(ShoppingListRepository shoppingListRepository, UserRepository userRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<ShoppingList> find(UUID id){
        return shoppingListRepository.findById(id);
    }

    @Override
    public Optional<ShoppingList> find(UUID id, User user){
        return Optional.ofNullable(shoppingListRepository.findByIdAndUser(id, user));
    }

    @Override
    public List<ShoppingList> findAll(){
        return shoppingListRepository.findAll();
    }

    @Override
    public List<ShoppingList> findAll(User user){
        return shoppingListRepository.findAllByUser(user);
    }

    @Override
    public Optional<List<ShoppingList>> findAllByStatus(Status status){
        return Optional.ofNullable(shoppingListRepository.findAllByStatus(status));
    }

    @Override
    public Optional<List<ShoppingList>> findAllByUser(UUID userId){
        return userRepository.findById(userId)
                .map(shoppingListRepository::findAllByUser);
    }

    @Override
    public Optional<List<ShoppingList>> findAllByUserAndStatus(UUID userId, Status status){
        return userRepository.findById(userId)
                .map(user -> shoppingListRepository.findAllByUserAndStatus(user, status));
    }

    @Override
    public Optional<ShoppingList> findByUserAndName(UUID userId, String name) {
        return userRepository.findById(userId)
                .map(user -> shoppingListRepository.findByUserAndName(user, name));
    }


    @Override
    public void create(ShoppingList shoppingList){
        shoppingListRepository.save(shoppingList);
    }

    @Override
    public void update(ShoppingList shoppingList){
        shoppingListRepository.save(shoppingList);
    }

    @Override
    public void delete(UUID id){
        shoppingListRepository.deleteById(id);
    }

}
