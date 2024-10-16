package org.example.shoppinglistmanager.service.api;

import org.example.shoppinglistmanager.entity.Product;
import org.example.shoppinglistmanager.entity.ShoppingList;
import org.example.shoppinglistmanager.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Optional<Product> find(UUID id);
    Optional<Product> findByName(String name);
    List<Product> findAll();
    List<Product> findAll(ShoppingList shoppingList);

    Optional<List<Product>> findAllByUser(UUID userId);
    Optional<List<Product>> findAllByUserAndShoppingList(UUID userId, UUID shoppingListId);
    Optional<List<Product>> findAllByShoppingList(UUID shoppingListId);

    void create(Product product);
    void update(Product product);
    void delete(UUID id);
}
