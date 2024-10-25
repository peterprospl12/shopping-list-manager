package org.example.shoppinglistmanager.shoppingList.service.api;

import org.example.shoppinglistmanager.shoppingList.entity.Product;
import org.example.shoppinglistmanager.shoppingList.entity.ShoppingList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Optional<Product> find(UUID id);
    Optional<Product> findByName(String name);
    Optional<Product> findByShoppingList(UUID shoppingListId, UUID productId);
    List<Product> findAll();
    List<Product> findAll(ShoppingList shoppingList);

    Optional<List<Product>> findAllByShoppingList(UUID shoppingListId);

    void create(Product product);
    void update(Product product);
    void delete(UUID id);
}
