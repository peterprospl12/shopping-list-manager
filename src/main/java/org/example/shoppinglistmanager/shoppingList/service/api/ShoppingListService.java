package org.example.shoppinglistmanager.shoppingList.service.api;

import org.example.shoppinglistmanager.shoppingList.entity.ShoppingList;
import org.example.shoppinglistmanager.user.entity.User;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Status;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShoppingListService {
    Optional<ShoppingList> find(UUID id);
    Optional<ShoppingList> find(UUID id, User user);
    List<ShoppingList> findAll();
    List<ShoppingList> findAll(User user);

    Optional<List<ShoppingList>> findAllByStatus(Status status);
    Optional<List<ShoppingList>> findAllByUser(UUID userId);
    Optional<List<ShoppingList>> findAllByUserAndStatus(UUID userId, Status status);
    Optional<ShoppingList> findByUserAndName(UUID userId, String name);
    Optional<ShoppingList> findUserShoppingList(UUID userId, UUID shoppingListId);

    void create(ShoppingList shoppingList);
    void update(ShoppingList shoppingList);
    void delete(UUID id);
}
