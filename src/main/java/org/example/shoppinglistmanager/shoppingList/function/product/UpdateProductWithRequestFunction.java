package org.example.shoppinglistmanager.shoppingList.function.product;

import org.example.shoppinglistmanager.shoppingList.dto.product.PatchProductRequest;
import org.example.shoppinglistmanager.shoppingList.entity.Product;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateProductWithRequestFunction implements BiFunction<Product, PatchProductRequest, Product> {

    @Override
    public Product apply(Product entity, PatchProductRequest request) {
        return Product.builder()
                .id(entity.getId())
                .name(request.getName())
                .category(request.getCategory())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .isBought(request.isBought())
                .shoppingList(entity.getShoppingList())
                .build();
    }
}
