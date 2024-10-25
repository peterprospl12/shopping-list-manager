package org.example.shoppinglistmanager.shoppingList.controller.api;

import org.example.shoppinglistmanager.shoppingList.dto.product.GetProductResponse;
import org.example.shoppinglistmanager.shoppingList.dto.product.GetProductsResponse;
import org.example.shoppinglistmanager.shoppingList.dto.product.PutProductRequest;

import java.util.UUID;

public interface ProductController {

    GetProductsResponse getProducts();
    GetProductsResponse getShoppingListProducts(UUID shoppingListId);

    GetProductResponse getProduct(UUID productId);
    GetProductResponse getShoppingListProduct(UUID shoppingListId, UUID productId);

    void putProduct(UUID id, PutProductRequest request);
    void deleteProduct(UUID id);

}
