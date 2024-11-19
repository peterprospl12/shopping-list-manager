package shopping.list.manager.productservice.product.service.api;


import shopping.list.manager.productservice.product.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Optional<Product> find(UUID id);

    List<Product> findAll();

    Optional<List<Product>> findAllByShoppingList(UUID shoppingListId);
    Optional<List<Product>> findAllByUser(UUID userId);
    Optional<List<Product>> findAllByName(String name);

    boolean userExists(UUID userId);
    boolean shoppingListExists(UUID shoppingListId);

    void create(Product product);
    void update(Product product);
    void delete(UUID id);
    void deleteAllByUserId(UUID userId);
    void deleteAllByShoppingListId(UUID shoppingListId);
}
