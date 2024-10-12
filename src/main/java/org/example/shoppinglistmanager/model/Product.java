package org.example.shoppinglistmanager.model;

import lombok.*;
import org.example.shoppinglistmanager.model.enums.Category;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Product implements Serializable {
    private String name;
    private Category category;
    private double price;
    private int quantity;
    private boolean isBought;
}
