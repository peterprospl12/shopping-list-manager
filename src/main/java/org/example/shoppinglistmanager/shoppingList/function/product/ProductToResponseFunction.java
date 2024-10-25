package org.example.shoppinglistmanager.shoppingList.function.product;

import org.example.shoppinglistmanager.shoppingList.dto.product.GetProductResponse;
import org.example.shoppinglistmanager.shoppingList.dto.product.GetProductsResponse;
import org.example.shoppinglistmanager.shoppingList.entity.Product;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductToResponseFunction implements Function<Product, GetProductResponse> {

    @Override
    public GetProductResponse apply(Product entity) {
        return GetProductResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(entity.getCategory())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .isBought(entity.isBought())
                .shoppingList(GetProductResponse.ShoppingList.builder()
                        .id(entity.getShoppingList().getId())
                        .name(entity.getShoppingList().getName())
                        .build())
                .build();
    }
}
