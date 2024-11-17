package shopping.list.manager.productservice.listeners.api;

import java.util.UUID;

public interface ShoppingListServiceClient {
    boolean shoppingListExists(UUID shoppingListId);
}
