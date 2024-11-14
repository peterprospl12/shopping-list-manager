package shopping.list.manager.productservice.product.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.list.manager.productservice.product.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    Optional<List<Product>> findAllByName(String name);

    Optional<List<Product>> findAllByShoppingListId(UUID shoppingListId);

    Optional<List<Product>> findAllByUserId(UUID userId);
}
