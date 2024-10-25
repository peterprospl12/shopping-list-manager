package org.example.shoppinglistmanager.shoppingList.function.shoppingList;

import org.example.shoppinglistmanager.shoppingList.dto.product.GetProductsResponse;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.GetShoppingListsResponse;
import org.example.shoppinglistmanager.shoppingList.entity.ShoppingList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class ShoppingListsToResponseFunction implements Function<List<ShoppingList>, GetShoppingListsResponse> {

    @Override
    public GetShoppingListsResponse apply(List<ShoppingList> entities) {
        return GetShoppingListsResponse.builder()
                .shoppingLists(entities.stream()
                    .map(shoppingList -> GetShoppingListsResponse.ShoppingList.builder()
                            .id(shoppingList.getId())
                            .name(shoppingList.getName())
                            .build())
                    .toList())
                .build();
    }
}
