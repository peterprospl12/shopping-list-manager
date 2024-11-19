package shopping.list.manager.userservice.user.service.api;

import java.util.UUID;

public interface UserEventPublisher {
    void notifyUserDeleted(UUID userId);
}
