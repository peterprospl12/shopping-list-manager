package org.example.shoppinglistmanager.service.impl;

import org.example.shoppinglistmanager.entity.Product;
import org.example.shoppinglistmanager.entity.ShoppingList;
import org.example.shoppinglistmanager.repository.api.ProductRepository;
import org.example.shoppinglistmanager.repository.api.ShoppingListRepository;
import org.example.shoppinglistmanager.repository.api.UserRepository;
import org.example.shoppinglistmanager.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductDefaultService implements ProductService {

    private final ProductRepository productRepository;
    private final ShoppingListRepository shoppingListRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProductDefaultService(ProductRepository productRepository, ShoppingListRepository shoppingListRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.shoppingListRepository = shoppingListRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Product> find(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.ofNullable(productRepository.findByName(name));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAll(ShoppingList shoppingList) {
        return productRepository.findAllByShoppingList(shoppingList);
    }

    @Override
    public Optional<List<Product>> findAllByUser(UUID userId) {
        return userRepository.findById(userId)
                .map(productRepository::findALlByUser);
    }

    @Override
    public Optional<List<Product>> findAllByUserAndShoppingList(UUID userId, UUID shoppingListId) {
        return userRepository.findById(userId)
                .flatMap(user -> shoppingListRepository.findById(shoppingListId)
                        .map(shoppingList -> productRepository
                                .findALlByShoppingListAndUser(shoppingList, user)));
    }

    @Override
    public Optional<List<Product>> findAllByShoppingList(UUID shoppingListId) {
        return shoppingListRepository.findById(shoppingListId)
                .map(productRepository::findAllByShoppingList);
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }
}
