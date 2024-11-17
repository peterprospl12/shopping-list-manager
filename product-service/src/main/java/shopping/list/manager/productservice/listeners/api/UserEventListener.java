package shopping.list.manager.productservice.listeners.api;

import java.util.UUID;

public interface UserEventListener {
    boolean userExists(UUID userId);
}
