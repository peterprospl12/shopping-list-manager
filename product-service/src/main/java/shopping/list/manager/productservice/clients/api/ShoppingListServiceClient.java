package shopping.list.manager.productservice.clients.api;

import java.util.UUID;

public interface ShoppingListServiceClient {
    boolean shoppingListExists(UUID shoppingListId);
}
