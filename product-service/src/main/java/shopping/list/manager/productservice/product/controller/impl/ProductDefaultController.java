package shopping.list.manager.productservice.product.controller.impl;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import shopping.list.manager.productservice.product.controller.api.ProductController;
import shopping.list.manager.productservice.product.dto.GetProductResponse;
import shopping.list.manager.productservice.product.dto.GetProductsResponse;
import shopping.list.manager.productservice.product.dto.PatchProductRequest;
import shopping.list.manager.productservice.product.dto.PutProductRequest;
import shopping.list.manager.productservice.product.function.ProductToResponseFunction;
import shopping.list.manager.productservice.product.function.ProductsToResponseFunction;
import shopping.list.manager.productservice.product.function.RequestToProductFunction;
import shopping.list.manager.productservice.product.function.UpdateProductWithRequestFunction;
import shopping.list.manager.productservice.product.service.api.ProductService;

import java.util.UUID;

@RestController
@Log
public class ProductDefaultController implements ProductController {
    private final ProductService service;
    private final ProductToResponseFunction productToResponse;
    private final ProductsToResponseFunction productsToResponse;
    private final RequestToProductFunction requestToProduct;
    private final UpdateProductWithRequestFunction updateProductWithRequestFunction;

    @Autowired
    public ProductDefaultController(ProductService service,
                                    ProductToResponseFunction productToResponse,
                                    ProductsToResponseFunction productsToResponse,
                                    RequestToProductFunction requestToProduct, UpdateProductWithRequestFunction updateProductWithRequestFunction) {
        this.service = service;
        this.productToResponse = productToResponse;
        this.productsToResponse = productsToResponse;
        this.requestToProduct = requestToProduct;
        this.updateProductWithRequestFunction = updateProductWithRequestFunction;
    }

    @Override
    public GetProductsResponse getProducts() {
        return productsToResponse.apply(service.findAll());
    }

    @Override
    public GetProductsResponse getShoppingListProducts(UUID shoppingListId) {
        return service.findAllByShoppingList(shoppingListId)
                .map(productsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetProductsResponse getProductsByName(String name) {
        return productsToResponse.apply(service.findAllByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public GetProductResponse getProduct(UUID productId) {
        return service.find(productId)
                .map(productToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @Override
    public void putProduct(UUID id, PutProductRequest request) {
        service.create(requestToProduct.apply(id, request));
    }

    @Override
    public void deleteProduct(UUID id){
        service.find(id).ifPresentOrElse(
            product -> service.delete(id),
            () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
        );
    }

    @Override
    public void patchProduct(UUID id, PatchProductRequest request) {
        service.update(updateProductWithRequestFunction.apply(service.find(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), request));
    }

    @Override
    public ResponseEntity<Void> handleShoppingListDeleted(UUID shoppingListId) {
        service.deleteAllByShoppingListId(shoppingListId);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleResponseStatusException(ResponseStatusException ex) {
        return ex.getReason();
    }
}
