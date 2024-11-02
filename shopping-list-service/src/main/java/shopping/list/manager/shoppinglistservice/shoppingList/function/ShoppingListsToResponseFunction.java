package shopping.list.manager.shoppinglistservice.shoppingList.function;

import shopping.list.manager.shoppinglistservice.shoppingList.dto.GetShoppingListsResponse;
import shopping.list.manager.shoppinglistservice.shoppingList.entity.ShoppingList;
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
