package shopping.list.manager.productservice.product.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import shopping.list.manager.productservice.listeners.api.ShoppingListServiceClient;
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
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProductDefaultService(ProductRepository productRepository,
                                 ShoppingListServiceClient shoppingListService,
                                 RabbitTemplate rabbitTemplate) {
        this.productRepository = productRepository;
        this.shoppingListService = shoppingListService;
        this.rabbitTemplate = rabbitTemplate;
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
        return productRepository.findAllByShoppingListId(shoppingListId);
    }

    @Override
    public Optional<List<Product>> findAllByName(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public Optional<List<Product>> findAllByUser(UUID userId) {
        return productRepository.findAllByUserId(userId);
    }

    @Override
    public boolean shoppingListExists(UUID shoppingListId) {
        return shoppingListService.shoppingListExists(shoppingListId);
    }

    @Override
    public void deleteProductsByUser(UUID userId) {
        productRepository.deleteAllByUserId(userId);
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


    private boolean UserExists(UUID userId) {
        Boolean exists = rabbitTemplate.convertSendAndReceiveAsType(
                "user-exists.request.queue",
                userId,
                new ParameterizedTypeReference<>() {
                });
        return exists != null && exists;
    }
}
