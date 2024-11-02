package shopping.list.manager.productservice.shoppingList.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public interface ShoppingListController {

    @DeleteMapping("/api/shopping-lists/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteShoppingList(
            @PathVariable("id")
            UUID id
    );
}
