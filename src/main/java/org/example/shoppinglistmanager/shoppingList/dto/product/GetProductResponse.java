package org.example.shoppinglistmanager.shoppingList.dto.product;

import lombok.*;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Category;

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
