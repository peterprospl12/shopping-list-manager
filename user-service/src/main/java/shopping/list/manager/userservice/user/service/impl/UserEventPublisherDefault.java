package shopping.list.manager.userservice.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shopping.list.manager.userservice.user.service.api.UserEventPublisher;

import java.util.UUID;

@Service
public class UserEventPublisherDefault implements UserEventPublisher {

    private final RestTemplate restTemplate;
    private final String gatewayUrl;

    @Autowired
    public UserEventPublisherDefault(RestTemplate restTemplate, @Value("${gateway.url}") String gatewayUrl) {
        this.restTemplate = restTemplate;
        this.gatewayUrl = gatewayUrl;
    }

    @Override
    public void notifyUserDeleted(UUID userId) {
        String shoppingListUrl = gatewayUrl + "/api/shopping-lists/user-deleted";

        try {
            restTemplate.postForEntity(shoppingListUrl, userId, Void.class);
        } catch (Exception e) {
            System.err.println("Error while notifying about user deletion: " + e.getMessage());
        }
    }
}
