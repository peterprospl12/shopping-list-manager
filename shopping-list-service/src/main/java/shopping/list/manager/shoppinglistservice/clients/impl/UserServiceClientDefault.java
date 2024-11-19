package shopping.list.manager.shoppinglistservice.clients.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shopping.list.manager.shoppinglistservice.clients.api.UserServiceClient;

import java.util.UUID;

@Service
public class UserServiceClientDefault implements UserServiceClient {

    private final RestTemplate restTemplate;

    @Value("${gateway.url}")
    private String gatewayUrl;

    @Autowired
    public UserServiceClientDefault(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean userExists(UUID userId) {
        try {
            restTemplate.getForObject(gatewayUrl + "api/users/" + userId, Void.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
