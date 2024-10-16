package org.example.shoppinglistmanager.repository.api;

import org.example.shoppinglistmanager.entity.User;
import org.example.shoppinglistmanager.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.shoppinglistmanager.entity.ShoppingList;

import java.util.List;
import java.util.UUID;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, UUID>     {
    ShoppingList findByIdAndUser(UUID id, User user);
    List<ShoppingList> findAllByUser(User user);
    List<ShoppingList> findAllByStatus(Status status);
    List<ShoppingList> findAllByUserAndStatus(User user, Status status);
    ShoppingList findByUserAndName(User user, String name);
}
