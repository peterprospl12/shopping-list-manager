package org.example.shoppinglistmanager.dto;

import lombok.*;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private List<ShoppingListDTO> shoppingLists;
}