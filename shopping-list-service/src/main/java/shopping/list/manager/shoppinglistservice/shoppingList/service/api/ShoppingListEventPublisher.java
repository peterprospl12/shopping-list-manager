package shopping.list.manager.shoppinglistservice.shoppingList.service.api;

import java.util.UUID;

public interface ShoppingListEventPublisher {
    void notifyShoppingListDeleted(UUID shoppingListId);
}
