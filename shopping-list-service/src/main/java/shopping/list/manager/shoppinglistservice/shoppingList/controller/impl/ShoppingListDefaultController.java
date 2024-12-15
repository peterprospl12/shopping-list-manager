package shopping.list.manager.shoppinglistservice.shoppingList.controller.impl;

import org.springframework.http.ResponseEntity;
import shopping.list.manager.shoppinglistservice.shoppingList.controller.api.ShoppingListController;
import shopping.list.manager.shoppinglistservice.shoppingList.dto.GetShoppingListResponse;
import shopping.list.manager.shoppinglistservice.shoppingList.dto.GetShoppingListsResponse;
import shopping.list.manager.shoppinglistservice.shoppingList.dto.PatchShoppingListRequest;
import shopping.list.manager.shoppinglistservice.shoppingList.dto.PutShoppingListRequest;
import shopping.list.manager.shoppinglistservice.shoppingList.function.RequestToShoppingListFunction;
import shopping.list.manager.shoppinglistservice.shoppingList.function.ShoppingListToResponseFunction;
import shopping.list.manager.shoppinglistservice.shoppingList.function.ShoppingListsToResponseFunction;
import shopping.list.manager.shoppinglistservice.shoppingList.function.UpdateShoppingListWithRequestFunction;
import shopping.list.manager.shoppinglistservice.shoppingList.service.api.ShoppingListService;
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
    private final UpdateShoppingListWithRequestFunction updateShoppingListWithRequestFunction;

    @Autowired
    public ShoppingListDefaultController(ShoppingListService shoppingListService,
                                         ShoppingListToResponseFunction shoppingListToResponse,
                                         ShoppingListsToResponseFunction shoppingListsToResponse,
                                         RequestToShoppingListFunction requestToShoppingList, UpdateShoppingListWithRequestFunction updateShoppingListWithRequestFunction) {
        this.service = shoppingListService;
        this.shoppingListToResponse = shoppingListToResponse;
        this.shoppingListsToResponse = shoppingListsToResponse;
        this.requestToShoppingList = requestToShoppingList;
        this.updateShoppingListWithRequestFunction = updateShoppingListWithRequestFunction;
    }


    @Override
    public GetShoppingListsResponse getShoppingLists() {
        return shoppingListsToResponse.apply(service.findAll());
    }

    @Override
    public GetShoppingListsResponse getUserShoppingLists(UUID userId) {
        return service.findAllByUserId(userId)
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
    public void putShoppingList(UUID id, PutShoppingListRequest request) {
        service.create(requestToShoppingList.apply(id, request));
    }

    @Override
    public void patchShoppingList(UUID id, PatchShoppingListRequest request) {
        service.update(updateShoppingListWithRequestFunction.apply(service.find(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), request));
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

    @Override
    @Transactional
    public ResponseEntity<Void> handleUserDeleted(UUID userId) {
        service.deleteAllByUserId(userId);
        return ResponseEntity.ok().build();
    }
}
