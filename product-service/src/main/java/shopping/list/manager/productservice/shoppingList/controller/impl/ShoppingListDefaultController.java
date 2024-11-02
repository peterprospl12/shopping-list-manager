package shopping.list.manager.productservice.shoppingList.controller.impl;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import shopping.list.manager.productservice.shoppingList.controller.api.ShoppingListController;
import shopping.list.manager.productservice.shoppingList.service.api.ShoppingListService;

import java.util.UUID;

@RestController
@Log
public class ShoppingListDefaultController implements ShoppingListController {
    private final ShoppingListService shoppingListService;

    public ShoppingListDefaultController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @Override
    public void deleteShoppingList(UUID id) {
        shoppingListService.find(id)
                .ifPresentOrElse(
                        shoppingList -> shoppingListService.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
