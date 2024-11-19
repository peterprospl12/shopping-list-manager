package shopping.list.manager.productservice.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shopping.list.manager.productservice.clients.api.ShoppingListServiceClient;
import shopping.list.manager.productservice.product.entity.Product;
import shopping.list.manager.productservice.product.repository.api.ProductRepository;
import shopping.list.manager.productservice.product.service.api.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class ProductDefaultService implements ProductService {

    private final ProductRepository productRepository;
    private final ShoppingListServiceClient shoppingListService;
    private final Logger logger = Logger.getLogger(ProductDefaultService.class.getName());

    @Autowired
    public ProductDefaultService(ProductRepository productRepository,
                                 ShoppingListServiceClient shoppingListService) {
        this.productRepository = productRepository;
        this.shoppingListService = shoppingListService;
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
    public void create(Product product) {
        if (!shoppingListService.shoppingListExists(product.getShoppingListId())) {
            logger.warning("Shopping list with id " + product.getShoppingListId() + " does not exist");
            return;
        }
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

    @Override
    @Transactional
    public void deleteAllByShoppingListId(UUID shoppingListId) {
        productRepository.deleteAllByShoppingListId(shoppingListId);
    }
}
