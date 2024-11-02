package shopping.list.manager.productservice.shoppingList.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopping.list.manager.productservice.shoppingList.entity.ShoppingList;

import java.util.UUID;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, UUID> {

}
