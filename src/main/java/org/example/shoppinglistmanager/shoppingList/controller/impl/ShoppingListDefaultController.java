package org.example.shoppinglistmanager.shoppingList.controller.impl;

import org.example.shoppinglistmanager.shoppingList.controller.api.ShoppingListController;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.GetShoppingListResponse;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.GetShoppingListsResponse;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.PutShoppingListRequest;
import org.example.shoppinglistmanager.shoppingList.function.shoppingList.RequestToShoppingListFunction;
import org.example.shoppinglistmanager.shoppingList.function.shoppingList.ShoppingListToResponseFunction;
import org.example.shoppinglistmanager.shoppingList.function.shoppingList.ShoppingListsToResponseFunction;
import org.example.shoppinglistmanager.shoppingList.service.api.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class ShoppingListDefaultController implements ShoppingListController {
    private final ShoppingListService service;
    private final ShoppingListToResponseFunction shoppingListToResponse;
    private final ShoppingListsToResponseFunction shoppingListsToResponse;
    private final RequestToShoppingListFunction requestToShoppingList;

    @Autowired
    public ShoppingListDefaultController(ShoppingListService shoppingListService,
                                         ShoppingListToResponseFunction shoppingListToResponse,
                                         ShoppingListsToResponseFunction shoppingListsToResponse,
                                         RequestToShoppingListFunction requestToShoppingList) {
        this.service = shoppingListService;
        this.shoppingListToResponse = shoppingListToResponse;
        this.shoppingListsToResponse = shoppingListsToResponse;
        this.requestToShoppingList = requestToShoppingList;
    }


    @Override
    public GetShoppingListsResponse getShoppingLists() {
        return shoppingListsToResponse.apply(service.findAll());
    }

    @Override
    public GetShoppingListsResponse getUserShoppingLists(UUID userId) {
        return service.findAllByUser(userId)
                .map(shoppingListsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @Transactional
    @Override
    public GetShoppingListResponse  getShoppingList(UUID shoppingListId) {
        return service.find(shoppingListId)
                .map(shoppingListToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetShoppingListResponse getUserShoppingList(UUID userId, UUID shoppingListId) {
        return service.findUserShoppingList(userId, shoppingListId)
                .map(shoppingListToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putShoppingList(UUID id, PutShoppingListRequest request) {
        service.create(requestToShoppingList.apply(id, request));
    }

    @Override
    public void deleteShoppingList(UUID id) {
        service.find(id).ifPresentOrElse(
                shoppingList -> service.delete(id),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }
}
