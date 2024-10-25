package org.example.shoppinglistmanager.shoppingList.dto.shoppingList;

import lombok.*;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetShoppingListResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class User {
        private UUID id;
        private String email;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Product {
        private UUID id;
        private String name;
    }
    private UUID id;
    private String name;
    private LocalDate date;
    private Status status;
    private User user;
    private List<Product> products;

}
