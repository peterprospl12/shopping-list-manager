package shopping.list.manager.productservice.product.dto;

import lombok.*;
import shopping.list.manager.productservice.product.entity.enums.Category;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetProductResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class ShoppingList {
        private UUID id;
        private String name;
    }

    private UUID id;
    private String name;
    private Category category;
    private double price;
    private int quantity;
    private boolean isBought;
    private ShoppingList shoppingList;
}
