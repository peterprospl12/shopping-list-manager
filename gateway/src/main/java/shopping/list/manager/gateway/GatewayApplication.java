package shopping.list.manager.gateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${product.service.url}") String productUrl,
			@Value("${shoppingList.service.url}") String shoppingListUrl,
			@Value("${user.service.url}") String userUrl,
			@Value("${gateway.host}") String host
	) {
		return builder
				.routes()
				.route("products", route -> route
						.host(host)
						.and()
						.path("/api/products/**")
						.uri(productUrl)
				)
				.route("shoppingLists", route -> route
						.host(host)
						.and()
						.path("/api/shopping-lists/**")
						.uri(shoppingListUrl)
				)
				.route("users", route -> route
						.host(host)
						.and()
						.path("/api/users/**")
						.uri(userUrl)
				)
				.build();
	}

}
