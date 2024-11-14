package shopping.list.manager.productservice.product.function;

import org.springframework.stereotype.Component;
import shopping.list.manager.productservice.product.dto.PatchProductRequest;
import shopping.list.manager.productservice.product.entity.Product;

import java.util.function.BiFunction;

@Component
public class UpdateProductWithRequestFunction implements BiFunction<Product, PatchProductRequest, Product> {

    @Override
    public Product apply(Product entity, PatchProductRequest request) {
        return Product.builder()
                .id(entity.getId())
                .name(request.getName())
                .category(request.getCategory())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .isBought(request.isBought())
                .shoppingListId(entity.getShoppingListId())
                .userId(entity.getUserId())
                .build();
    }
}
