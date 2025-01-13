package shopping.list.manager.productservice.product.entity;

import jakarta.persistence.*;
import lombok.*;
import shopping.list.manager.productservice.product.entity.enums.Category;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @Builder.Default
    @Column(columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "is_bought")
    private boolean isBought;

    @JoinColumn(name = "shopping_list_id")
    private UUID shoppingListId;
}
