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
public class PutProductRequest {
    private String name;
    private Category category;
    private double price;
    private int quantity;
    private boolean isBought;
    private UUID shoppingList;
}
