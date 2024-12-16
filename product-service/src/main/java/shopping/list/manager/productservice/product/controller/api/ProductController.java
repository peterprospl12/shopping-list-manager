package shopping.list.manager.productservice.product.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopping.list.manager.productservice.product.dto.GetProductResponse;
import shopping.list.manager.productservice.product.dto.GetProductsResponse;
import shopping.list.manager.productservice.product.dto.PatchProductRequest;
import shopping.list.manager.productservice.product.dto.PutProductRequest;

import java.util.UUID;

public interface ProductController {

    @GetMapping("api/products")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductsResponse getProducts();

    @GetMapping("api/shopping-lists/{shoppingListId}/products")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductsResponse getShoppingListProducts(@PathVariable("shoppingListId") UUID shoppingListId);

    @GetMapping("api/products/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductsResponse getProductsByName(@PathVariable("name") String name);

    @GetMapping("api/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductResponse getProduct(@PathVariable("productId") UUID productId);


    @PutMapping("api/products/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putProduct(@PathVariable("id") UUID id, @RequestBody PutProductRequest request);

    @PatchMapping("api/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchProduct(@PathVariable("id") UUID id, @RequestBody PatchProductRequest request);

    @DeleteMapping("api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(@PathVariable("id") UUID id);

    @PostMapping("api/products/shopping-list-deleted")
    ResponseEntity<Void> handleShoppingListDeleted(@RequestBody UUID shoppingListId);

}
