package org.example.shoppinglistmanager.shoppingList.controller.api;

import org.example.shoppinglistmanager.shoppingList.dto.product.GetProductResponse;
import org.example.shoppinglistmanager.shoppingList.dto.product.GetProductsResponse;
import org.example.shoppinglistmanager.shoppingList.dto.product.PutProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ProductController {

    @GetMapping("api/products")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductsResponse getProducts();

    @GetMapping("api/shopping_lists/{shoppingListId}/products")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductsResponse getShoppingListProducts(@PathVariable("shoppingListId") UUID shoppingListId);

    @GetMapping("api/users/{userId}/products")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductsResponse getUserProducts(@PathVariable("userId") UUID userId);

    @GetMapping("api/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductResponse getProduct(@PathVariable("productId") UUID productId);

    @GetMapping("api/shopping_lists/{shoppingListId}/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductResponse getShoppingListProduct(@PathVariable("shoppingListId") UUID shoppingListId,
                                              @PathVariable("productId") UUID productId);

    @PutMapping("api/products/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putProduct(@PathVariable("id") UUID id, @RequestBody PutProductRequest request);

    @DeleteMapping("api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(@PathVariable("id") UUID id);

}
