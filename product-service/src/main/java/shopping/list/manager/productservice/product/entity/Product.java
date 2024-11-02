package shopping.list.manager.productservice.product.entity;

import jakarta.persistence.*;
import lombok.*;
import shopping.list.manager.productservice.product.entity.enums.Category;
import shopping.list.manager.productservice.shoppingList.entity.ShoppingList;
import shopping.list.manager.productservice.user.entity.User;

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

    @ManyToOne
    @JoinColumn(name = "shopping_list")
    private ShoppingList shoppingList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
