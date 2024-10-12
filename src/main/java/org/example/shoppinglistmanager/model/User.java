package org.example.shoppinglistmanager.model;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    @Builder.Default
    private List<ShoppingList> shoppingLists = new ArrayList<>();

    public void addShoppingList(ShoppingList shoppingList) {
        shoppingLists.add(shoppingList);
    }
}
