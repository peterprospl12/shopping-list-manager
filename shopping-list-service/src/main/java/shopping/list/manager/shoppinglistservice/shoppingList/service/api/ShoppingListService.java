package shopping.list.manager.shoppinglistservice.shoppingList.service.api;

import shopping.list.manager.shoppinglistservice.shoppingList.entity.ShoppingList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShoppingListService {
    Optional<ShoppingList> find(UUID id);
    List<ShoppingList> findAll();

    void create(ShoppingList shoppingList);
    void update(ShoppingList shoppingList);
    void delete(UUID id);
}
