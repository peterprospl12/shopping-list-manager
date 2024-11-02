package shopping.list.manager.shoppinglistservice.shoppingList.function;

import shopping.list.manager.shoppinglistservice.shoppingList.dto.PutShoppingListRequest;
import shopping.list.manager.shoppinglistservice.shoppingList.entity.ShoppingList;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToShoppingListFunction implements BiFunction<UUID, PutShoppingListRequest, ShoppingList> {

    @Override
    public ShoppingList apply (UUID id, PutShoppingListRequest request){
        return ShoppingList.builder()
                .id(id)
                .name(request.getName())
                .status(request.getStatus())
                .date(request.getDate())
                .build();
    }
}