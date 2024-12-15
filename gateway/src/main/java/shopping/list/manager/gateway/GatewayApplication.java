package shopping.list.manager.gateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

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
						.or()
						.path("/api/users/*/products")
						.or()
						.path("/api/shopping-lists/*/products")
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

	@Bean
	public CorsWebFilter corsWebFilter() {

		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Collections.singletonList("*"));
		corsConfig.setMaxAge(3600L);
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
		corsConfig.addAllowedHeader("*");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}

}
