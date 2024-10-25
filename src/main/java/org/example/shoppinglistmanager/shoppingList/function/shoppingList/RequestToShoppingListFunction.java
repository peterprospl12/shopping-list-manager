package org.example.shoppinglistmanager.shoppingList.function.shoppingList;

import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.PutShoppingListRequest;
import org.example.shoppinglistmanager.shoppingList.entity.ShoppingList;
import org.example.shoppinglistmanager.user.entity.User;
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
                .user(User.builder()
                        .id(request.getUser())
                        .build())
                .build();
    }
}