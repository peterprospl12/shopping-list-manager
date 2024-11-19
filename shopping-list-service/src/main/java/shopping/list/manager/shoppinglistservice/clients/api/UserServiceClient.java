package shopping.list.manager.shoppinglistservice.clients.api;

import java.util.UUID;

public interface UserServiceClient {
    boolean userExists(UUID userId);
}
