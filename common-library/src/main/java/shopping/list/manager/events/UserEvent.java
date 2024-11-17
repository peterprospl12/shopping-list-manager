package shopping.list.manager.events;

import shopping.list.manager.enums.UserEvents;

import java.util.UUID;

public class UserEvent {
    private UUID userId;
    private UserEvents eventType;

    public UserEvent() {}

    public UserEvent(UUID userId, UserEvents eventType) {
        this.userId = userId;
        this.eventType = eventType;
    }

    public UUID getUserId() {
        return userId;
    }

    public UserEvents getEventType() {
        return eventType;
    }
}
