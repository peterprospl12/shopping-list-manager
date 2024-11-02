package shopping.list.manager.productservice.product.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.list.manager.productservice.product.entity.Product;
import shopping.list.manager.productservice.shoppingList.entity.ShoppingList;
import shopping.list.manager.productservice.user.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    Optional<Product> findByIdAndUserId(UUID id, User user);
    Optional<List<Product>> findAllByName(String name);

    List<Product> findAllByShoppingList(ShoppingList shoppingList);
    List<Product> findAllByUser(User user);
}
