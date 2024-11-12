package shopping.list.manager.productservice.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.list.manager.productservice.clients.api.ShoppingListServiceClient;
import shopping.list.manager.productservice.clients.api.UserServiceClient;
import shopping.list.manager.productservice.product.entity.Product;
import shopping.list.manager.productservice.product.repository.api.ProductRepository;
import shopping.list.manager.productservice.product.service.api.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductDefaultService implements ProductService {

    private final ProductRepository productRepository;
    private final ShoppingListServiceClient shoppingListService;
    private final UserServiceClient userService;

    @Autowired
    public ProductDefaultService(ProductRepository productRepository,
                                 ShoppingListServiceClient shoppingListService,
                                 UserServiceClient userService) {
        this.productRepository = productRepository;
        this.shoppingListService = shoppingListService;
        this.userService = userService;
    }

    @Override
    public Optional<Product> find(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<List<Product>> findAllByShoppingList(UUID shoppingListId) {
        return productRepository.findAllByShoppingList(shoppingListId);
    }

    @Override
    public Optional<List<Product>> findAllByName(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public Optional<List<Product>> findAllByUser(UUID userId) {
        return productRepository.findAllByUser(userId);
    }

    @Override
    public boolean userExists(UUID userId) {
        return userService.userExists(userId);
    }

    @Override
    public boolean shoppingListExists(UUID shoppingListId) {
        return shoppingListService.shoppingListExists(shoppingListId);
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
        productRepository.findById(id).ifPresent(productRepository::delete);
    }
}
