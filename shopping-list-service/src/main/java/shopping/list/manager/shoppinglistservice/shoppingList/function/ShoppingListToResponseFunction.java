package shopping.list.manager.shoppinglistservice.shoppingList.function;

import shopping.list.manager.shoppinglistservice.shoppingList.dto.GetShoppingListResponse;
import shopping.list.manager.shoppinglistservice.shoppingList.entity.ShoppingList;
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
                .userId(entity.getUserId())
                .build();
    }
}
