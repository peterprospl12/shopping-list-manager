package shopping.list.manager.productservice.product.function;

import org.springframework.stereotype.Component;
import shopping.list.manager.productservice.product.dto.PutProductRequest;
import shopping.list.manager.productservice.product.entity.Product;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToProductFunction implements BiFunction<UUID, PutProductRequest, Product> {

    @Override
    public Product apply(UUID id, PutProductRequest request) {
        return Product.builder()
                .id(id)
                .name(request.getName())
                .category(request.getCategory())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .isBought(request.isBought())
                .shoppingListId(request.getShoppingListId())
                .build();
    }
}
