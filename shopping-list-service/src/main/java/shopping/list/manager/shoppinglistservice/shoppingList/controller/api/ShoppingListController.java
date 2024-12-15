package shopping.list.manager.shoppinglistservice.shoppingList.controller.api;

import org.springframework.http.ResponseEntity;
import shopping.list.manager.shoppinglistservice.shoppingList.dto.GetShoppingListResponse;
import shopping.list.manager.shoppinglistservice.shoppingList.dto.GetShoppingListsResponse;
import shopping.list.manager.shoppinglistservice.shoppingList.dto.PatchShoppingListRequest;
import shopping.list.manager.shoppinglistservice.shoppingList.dto.PutShoppingListRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ShoppingListController {

    @GetMapping("api/shopping-lists")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShoppingListsResponse getShoppingLists();

    @GetMapping("api/users/{userId}/shopping-lists")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShoppingListsResponse getUserShoppingLists(@PathVariable("userId") UUID userId);

    @GetMapping("api/shopping-lists/{shoppingListId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShoppingListResponse getShoppingList(@PathVariable("shoppingListId") UUID shoppingListId);

    @PutMapping("api/shopping-lists/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putShoppingList(@PathVariable("id") UUID id, @RequestBody PutShoppingListRequest request);

    @PatchMapping("api/shopping-lists/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchShoppingList(@PathVariable("id") UUID id, @RequestBody PatchShoppingListRequest request);

    @DeleteMapping("api/shopping-lists/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteShoppingList(@PathVariable("id") UUID id);

    @PostMapping("api/shopping-lists/user-deleted")
    ResponseEntity<Void> handleUserDeleted(@RequestBody UUID userId);
}
