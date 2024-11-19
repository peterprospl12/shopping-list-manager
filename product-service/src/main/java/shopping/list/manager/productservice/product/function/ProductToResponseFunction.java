package shopping.list.manager.productservice.product.function;

import org.springframework.stereotype.Component;
import shopping.list.manager.productservice.product.dto.GetProductResponse;
import shopping.list.manager.productservice.product.entity.Product;

import java.util.function.Function;

@Component
public class ProductToResponseFunction implements Function<Product, GetProductResponse> {

    @Override
    public GetProductResponse apply(Product entity) {
        return GetProductResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(entity.getCategory())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .isBought(entity.isBought())
                .shoppingListId(entity.getShoppingListId())
                .build();
    }
}
