package org.example.shoppinglistmanager.shoppingList.function.shoppingList;

import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.GetShoppingListResponse;
import org.example.shoppinglistmanager.shoppingList.entity.ShoppingList;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ShoppingListToResponseFunction implements Function<ShoppingList, GetShoppingListResponse> {

    @Override
    public GetShoppingListResponse apply(ShoppingList entity){
        return GetShoppingListResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .date(entity.getDate())
                .user(GetShoppingListResponse.User.builder()
                        .id(entity.getUser().getId())
                        .email(entity.getUser().getEmail())
                        .build())
                .products(entity.getProducts().stream()
                        .map(product -> GetShoppingListResponse.Product.builder()
                                .id(product.getId())
                                .name(product.getName())
                                .build())
                        .toList())
                .build();
    }
}
