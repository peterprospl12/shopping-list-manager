package shopping.list.manager.shoppinglistservice.shoppingList.entity;

import jakarta.persistence.*;
import lombok.*;
import shopping.list.manager.shoppinglistservice.shoppingList.entity.enums.Status;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shopping_lists")
public class ShoppingList implements Serializable {
    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
