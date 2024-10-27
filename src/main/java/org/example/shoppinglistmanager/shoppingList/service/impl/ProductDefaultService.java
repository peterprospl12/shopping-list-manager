package org.example.shoppinglistmanager.shoppingList.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.shoppinglistmanager.shoppingList.entity.Product;
import org.example.shoppinglistmanager.shoppingList.entity.ShoppingList;
import org.example.shoppinglistmanager.shoppingList.repository.api.ProductRepository;
import org.example.shoppinglistmanager.shoppingList.repository.api.ShoppingListRepository;
import org.example.shoppinglistmanager.shoppingList.service.api.ProductService;
import org.example.shoppinglistmanager.user.repository.api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public Optional<Product> findByShoppingList(UUID shoppingListId, UUID productId) {
        return shoppingListRepository.findById(shoppingListId)
                .flatMap(shoppingList -> productRepository.findById(productId));
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
    public Optional<List<Product>> findAllByShoppingList(UUID shoppingListId) {
        return shoppingListRepository.findById(shoppingListId)
                .map(productRepository::findAllByShoppingList);
    }

    @Override
    public Optional<List<Product>> findAllByUser(UUID userId) {
        return Optional.of(
            shoppingListRepository.findAllByUser(userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + userId)))
                .stream()
                .flatMap(shoppingList -> productRepository.findAllByShoppingList(shoppingList).stream())
                .collect(Collectors.toList())
        );
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        if (productRepository.existsById(product.getId())) {
            productRepository.save(product);
        } else {
            throw new EntityNotFoundException("Product not found with ID: " + product.getId());
        }
    }

    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }
}
