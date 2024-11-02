package shopping.list.manager.shoppinglistservice.shoppingList.dto;

import lombok.*;
import shopping.list.manager.shoppinglistservice.shoppingList.entity.enums.Status;

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
public class GetShoppingListResponse {
    private UUID id;
    private String name;
    private LocalDate date;
    private Status status;
}
