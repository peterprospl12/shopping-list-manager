package org.example.shoppinglistmanager.shoppingList.controller.impl;

import org.example.shoppinglistmanager.shoppingList.controller.api.ProductController;
import org.example.shoppinglistmanager.shoppingList.dto.product.GetProductResponse;
import org.example.shoppinglistmanager.shoppingList.dto.product.GetProductsResponse;
import org.example.shoppinglistmanager.shoppingList.dto.product.PutProductRequest;
import org.example.shoppinglistmanager.shoppingList.function.product.ProductToResponseFunction;
import org.example.shoppinglistmanager.shoppingList.function.product.ProductsToResponseFunction;
import org.example.shoppinglistmanager.shoppingList.function.product.RequestToProductFunction;
import org.example.shoppinglistmanager.shoppingList.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
public class ProductDefaultController implements ProductController {
    private final ProductService service;
    private final ProductToResponseFunction productToResponse;
    private final ProductsToResponseFunction productsToResponse;
    private final RequestToProductFunction requestToProduct;

    @Autowired
    public ProductDefaultController(ProductService service,
                                    ProductToResponseFunction productToResponse,
                                    ProductsToResponseFunction productsToResponse,
                                    RequestToProductFunction requestToProduct) {
        this.service = service;
        this.productToResponse = productToResponse;
        this.productsToResponse = productsToResponse;
        this.requestToProduct = requestToProduct;
    }

    @Override
    public GetProductsResponse getProducts() {
        return productsToResponse.apply(service.findAll());
    }

    @Override
    public GetProductsResponse getShoppingListProducts(UUID shoppingListId) {
        return service.findAllByShoppingList(shoppingListId)
                .map(productsToResponse)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public GetProductResponse getProduct(UUID productId) {
        return service.find(productId)
                .map(productToResponse)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public GetProductResponse getShoppingListProduct(UUID shoppingListId, UUID productId) {
        return service.findByShoppingList(shoppingListId, productId)
                .map(productToResponse)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void putProduct(UUID id, PutProductRequest request) {
        service.create(requestToProduct.apply(id, request));
    }

    @Override
    public void deleteProduct(UUID id){
        service.delete(id);
    }

}
