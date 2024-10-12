package org.example.shoppinglistmanager.dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class ProductDTO implements Comparable<ProductDTO> {
    private String name;
    private String category;
    private double price;
    private int quantity;
    private boolean isBought;

    @Override
    public int compareTo(ProductDTO o) {
        return this.getName().compareTo(o.getName());
    }
}

