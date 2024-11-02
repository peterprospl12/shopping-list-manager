package shopping.list.manager.productservice.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.list.manager.productservice.product.entity.Product;
import shopping.list.manager.productservice.product.repository.api.ProductRepository;
import shopping.list.manager.productservice.product.service.api.ProductService;
import shopping.list.manager.productservice.shoppingList.entity.ShoppingList;
import shopping.list.manager.productservice.shoppingList.repository.api.ShoppingListRepository;
import shopping.list.manager.productservice.user.entity.User;
import shopping.list.manager.productservice.user.repository.api.UserRepository;

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
    public Optional<Product> find(UUID id, User user) {
        return productRepository.findByIdAndUserId(id, user);
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
    public List<Product> findAll(User user) {
        return productRepository.findAllByUser(user);
    }

    @Override
    public Optional<List<Product>> findAllByShoppingList(UUID shoppingListId) {
        return shoppingListRepository.findById(shoppingListId)
                .map(productRepository::findAllByShoppingList);
    }

    @Override
    public Optional<List<Product>> findAllByName(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public Optional<List<Product>> findAllByUser(UUID userId) {
        return userRepository.findById(userId)
                .map(productRepository::findAllByUser);
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
