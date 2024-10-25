package org.example.shoppinglistmanager.shoppingList.dto.shoppingList;

import lombok.*;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutShoppingListRequest {
    private String name;
    private LocalDate date;
    private Status status;
    private UUID user;
}
