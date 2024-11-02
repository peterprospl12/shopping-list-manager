package shopping.list.manager.productservice.product.function;


import org.springframework.stereotype.Component;
import shopping.list.manager.productservice.product.dto.GetProductsResponse;
import shopping.list.manager.productservice.product.entity.Product;

import java.util.List;
import java.util.function.Function;

@Component
public class ProductsToResponseFunction implements Function<List<Product>, GetProductsResponse> {

    @Override
    public GetProductsResponse apply(List<Product> entities) {
        return GetProductsResponse.builder()
                .products(entities.stream()
                    .map(product -> GetProductsResponse.Product.builder()
                            .id(product.getId())
                            .name(product.getName())
                            .build())
                        .toList())
                .build();
    }
}
