package org.example.shoppinglistmanager.shoppingList.controller.api;

import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.GetShoppingListResponse;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.GetShoppingListsResponse;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.PutShoppingListRequest;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ShoppingListController {

    @GetMapping("api/shopping_lists")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShoppingListsResponse getShoppingLists();

    @GetMapping("api/users/{userId}/shopping_lists")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShoppingListsResponse getUserShoppingLists(@PathVariable("userId") UUID userId);


    @GetMapping("api/shopping_lists/{shoppingListId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShoppingListResponse getShoppingList(@PathVariable("shoppingListId") UUID shoppingListId);

    @GetMapping("api/users/{userId}/shopping_lists/{shoppingListId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShoppingListResponse getUserShoppingList(@PathVariable("userId") UUID userId,
                                                @PathVariable("shoppingListId") UUID shoppingListId);

    @PutMapping("api/shopping_lists/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putShoppingList(@PathVariable("id") UUID id, @RequestBody PutShoppingListRequest request);

    @DeleteMapping("api/shopping_lists/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteShoppingList(@PathVariable("id") UUID id);
}
