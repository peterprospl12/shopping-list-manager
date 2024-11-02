package shopping.list.manager.shoppinglistservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ShoppingListServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingListServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(@Value("${product.service.url}") String baseUrl) {
        return new RestTemplateBuilder().rootUri(baseUrl).build();
    }

}
