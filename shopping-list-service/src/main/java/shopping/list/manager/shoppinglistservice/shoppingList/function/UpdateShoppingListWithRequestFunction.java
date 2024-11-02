package shopping.list.manager.shoppinglistservice.shoppingList.function;

import shopping.list.manager.shoppinglistservice.shoppingList.dto.PatchShoppingListRequest;
import shopping.list.manager.shoppinglistservice.shoppingList.entity.ShoppingList;
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
                .date(entity.getDate())
                .build();
    }
}
