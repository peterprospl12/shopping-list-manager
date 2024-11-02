package shopping.list.manager.productservice.product.service.api;


import shopping.list.manager.productservice.product.entity.Product;
import shopping.list.manager.productservice.shoppingList.entity.ShoppingList;
import shopping.list.manager.productservice.user.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Optional<Product> find(UUID id);
    Optional<Product> find(UUID id, User user);

    List<Product> findAll();
    List<Product> findAll(ShoppingList shoppingList);
    List<Product> findAll(User user);

    Optional<List<Product>> findAllByShoppingList(UUID shoppingListId);
    Optional<List<Product>> findAllByUser(UUID userId);
    Optional<List<Product>> findAllByName(String name);

    void create(Product product);
    void update(Product product);
    void delete(UUID id);
}
