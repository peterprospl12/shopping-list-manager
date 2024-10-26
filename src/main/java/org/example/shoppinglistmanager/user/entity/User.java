package org.example.shoppinglistmanager.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.shoppinglistmanager.shoppingList.entity.ShoppingList;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(name = "email", unique = true)
    private String email;

    @ToString.Exclude
    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ShoppingList> shoppingLists = new ArrayList<>();

}
