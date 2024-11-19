package shopping.list.manager.shoppinglistservice.shoppingList.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shopping.list.manager.shoppinglistservice.shoppingList.service.api.ShoppingListEventPublisher;

import java.util.UUID;

@Service
public class ShoppingListEventPublisherDefault implements ShoppingListEventPublisher {

    private final RestTemplate restTemplate;
    private final String gatewayUrl;


    public ShoppingListEventPublisherDefault(RestTemplate restTemplate, @Value("${gateway.url}") String gatewayUrl) {
        this.restTemplate = restTemplate;
        this.gatewayUrl = gatewayUrl;
    }

    @Override
    public void notifyShoppingListDeleted(UUID shoppingListId) {
        String url = this.gatewayUrl + "/api/products/shopping-list-deleted";

        try {
            this.restTemplate.postForEntity(url, shoppingListId, Void.class);
        } catch (Exception e) {
            System.err.println("Error while notifying about shopping list deletion: " + e.getMessage());
        }

    }
}
