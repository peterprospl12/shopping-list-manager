package org.example.shoppinglistmanager.shoppingList.function.product;

import org.example.shoppinglistmanager.shoppingList.dto.product.PutProductRequest;
import org.example.shoppinglistmanager.shoppingList.entity.Product;
import org.example.shoppinglistmanager.shoppingList.entity.ShoppingList;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToProductFunction implements BiFunction<UUID, PutProductRequest, Product> {

    @Override
    public Product apply(UUID id, PutProductRequest request) {
        return Product.builder()
                .id(id)
                .name(request.getName())
                .category(request.getCategory())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .isBought(request.isBought())
                .shoppingList(ShoppingList.builder()
                        .id(request.getShoppingList())
                        .build())
                .build();
    }
}
