package shopping.list.manager.productservice.shoppingList.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import shopping.list.manager.productservice.product.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "shopping_lists")
public class ShoppingList {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Builder.Default
    @OneToMany(mappedBy = "shoppingList", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Product> products = new ArrayList<>();
}
