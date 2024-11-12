package shopping.list.manager.productservice.clients.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shopping.list.manager.productservice.clients.api.ShoppingListServiceClient;

import java.util.UUID;

@Service
public class ShoppingListClientDefault implements ShoppingListServiceClient {

    private final RestTemplate restTemplate;

    @Value("${gateway.url}")
    private String gatewayUrl;

    @Autowired
    public ShoppingListClientDefault(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean shoppingListExists(UUID shoppingListId) {
        try {
            restTemplate.getForObject(gatewayUrl + "api/shopping-lists/" + shoppingListId, Void.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
