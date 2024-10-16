package org.example.shoppinglistmanager.repository.api;

import org.example.shoppinglistmanager.entity.Product;
import org.example.shoppinglistmanager.entity.ShoppingList;
import org.example.shoppinglistmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByName(String name);
    List<Product> findALlByUser(User user);
    List<Product> findAllByShoppingList(ShoppingList shoppingList);
    List<Product> findALlByShoppingListAndUser(ShoppingList shoppingList, User user);
}
