package shopping.list.manager.shoppinglistservice.shoppingList.controller.api;

import shopping.list.manager.shoppinglistservice.shoppingList.dto.GetShoppingListResponse;
import shopping.list.manager.shoppinglistservice.shoppingList.dto.GetShoppingListsResponse;
import shopping.list.manager.shoppinglistservice.shoppingList.dto.PutShoppingListRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ShoppingListController {

    @GetMapping("api/shopping_lists")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShoppingListsResponse getShoppingLists();

    @GetMapping("api/shopping_lists/{shoppingListId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShoppingListResponse getShoppingList(@PathVariable("shoppingListId") UUID shoppingListId);

    @PutMapping("api/shopping_lists/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putShoppingList(@PathVariable("id") UUID id, @RequestBody PutShoppingListRequest request);

    @DeleteMapping("api/shopping_lists/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteShoppingList(@PathVariable("id") UUID id);
}
