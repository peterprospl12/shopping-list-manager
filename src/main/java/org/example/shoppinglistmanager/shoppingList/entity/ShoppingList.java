package org.example.shoppinglistmanager.shoppingList.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Status;
import org.example.shoppinglistmanager.user.entity.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder.Default
    @OneToMany(mappedBy = "shoppingList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

}
