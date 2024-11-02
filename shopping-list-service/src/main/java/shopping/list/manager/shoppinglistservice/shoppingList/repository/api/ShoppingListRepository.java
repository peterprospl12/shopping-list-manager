package shopping.list.manager.shoppinglistservice.shoppingList.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.list.manager.shoppinglistservice.shoppingList.entity.ShoppingList;

import java.util.UUID;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, UUID>     {

}
