package shopping.list.manager.productservice.clients.api;

import java.util.UUID;

public interface UserServiceClient {
    boolean userExists(UUID userId);
}
