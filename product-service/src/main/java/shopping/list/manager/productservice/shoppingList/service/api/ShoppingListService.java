package shopping.list.manager.productservice.shoppingList.service.api;

import shopping.list.manager.productservice.shoppingList.entity.ShoppingList;

import java.util.Optional;
import java.util.UUID;

public interface ShoppingListService {

    Optional<ShoppingList> find(UUID id);

    void create(ShoppingList shoppingList);

    void delete(UUID id);
}
