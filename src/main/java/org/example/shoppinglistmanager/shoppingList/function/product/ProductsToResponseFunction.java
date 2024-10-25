package org.example.shoppinglistmanager.shoppingList.function.product;

import org.example.shoppinglistmanager.shoppingList.dto.product.GetProductsResponse;
import org.example.shoppinglistmanager.shoppingList.entity.Product;
import org.springframework.stereotype.Component;

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
