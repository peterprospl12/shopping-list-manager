package org.example.shoppinglistmanager.shoppingList.dto.shoppingList;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetShoppingListsResponse {

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

    @Singular
    private List<ShoppingList> shoppingLists;
}
