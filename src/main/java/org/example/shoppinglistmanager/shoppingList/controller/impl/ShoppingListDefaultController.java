package org.example.shoppinglistmanager.shoppingList.controller.impl;

import org.example.shoppinglistmanager.shoppingList.controller.api.ShoppingListController;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.GetShoppingListResponse;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.GetShoppingListsResponse;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.PutShoppingListRequest;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Status;
import org.example.shoppinglistmanager.shoppingList.function.shoppingList.RequestToShoppingListFunction;
import org.example.shoppinglistmanager.shoppingList.function.shoppingList.ShoppingListToResponseFunction;
import org.example.shoppinglistmanager.shoppingList.function.shoppingList.ShoppingListsToResponseFunction;
import org.example.shoppinglistmanager.shoppingList.service.api.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
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
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public GetShoppingListsResponse getUserShoppingListsByStatus(UUID userId, Status status) {
        return service.findAllByUserAndStatus(userId, status)
                .map(shoppingListsToResponse)
                .orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    @Override
    public GetShoppingListResponse  getShoppingList(UUID shoppingListId) {
        return service.find(shoppingListId)
                .map(shoppingListToResponse)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public GetShoppingListResponse getUserShoppingList(UUID userId, UUID shoppingListId) {
        return service.findByUserAndName(userId, this.getShoppingList(shoppingListId).getName())
                .map(shoppingListToResponse)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void putShoppingList(UUID id, PutShoppingListRequest request) {
        service.create(requestToShoppingList.apply(id, request));
    }

    @Override
    public void deleteShoppingList(UUID id) {
        service.delete(id);
    }
}
