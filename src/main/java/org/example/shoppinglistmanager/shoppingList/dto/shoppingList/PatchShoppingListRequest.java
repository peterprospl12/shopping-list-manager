package org.example.shoppinglistmanager.shoppingList.dto.shoppingList;

import lombok.*;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Status;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchShoppingListRequest {
    private String name;
    private Status status;
}
