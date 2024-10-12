package org.example.shoppinglistmanager.model;

import lombok.*;
import org.example.shoppinglistmanager.model.enums.Status;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingList implements Serializable {
    private String name;
    private LocalDate date;
    private Status status;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @Builder.Default
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }
}
