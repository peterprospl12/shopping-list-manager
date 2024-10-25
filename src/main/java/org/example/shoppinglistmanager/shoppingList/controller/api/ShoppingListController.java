package org.example.shoppinglistmanager.shoppingList.controller.api;

import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.GetShoppingListResponse;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.GetShoppingListsResponse;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.PutShoppingListRequest;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Status;

import java.util.UUID;

public interface ShoppingListController {

    GetShoppingListsResponse getShoppingLists();
    GetShoppingListsResponse getUserShoppingLists(UUID userId);
    GetShoppingListsResponse getUserShoppingListsByStatus(UUID userId, Status status);

    GetShoppingListResponse getShoppingList(UUID shoppingListId);
    GetShoppingListResponse getUserShoppingList(UUID userId, UUID shoppingListId);

    void putShoppingList(UUID id, PutShoppingListRequest request);
    void deleteShoppingList(UUID id);
}
