package org.example.shoppinglistmanager.shoppingList.function.shoppingList;

import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.PatchShoppingListRequest;
import org.example.shoppinglistmanager.shoppingList.entity.ShoppingList;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateShoppingListWithRequestFunction implements BiFunction<ShoppingList, PatchShoppingListRequest, ShoppingList> {

    @Override
    public ShoppingList apply(ShoppingList entity, PatchShoppingListRequest request) {
        return ShoppingList.builder()
                .id(entity.getId())
                .name(request.getName())
                .status(request.getStatus())
                .products(entity.getProducts())
                .user(entity.getUser())
                .date(entity.getDate())
                .build();
    }
}
