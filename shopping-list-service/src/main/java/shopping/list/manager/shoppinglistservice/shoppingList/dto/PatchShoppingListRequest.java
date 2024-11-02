package shopping.list.manager.shoppinglistservice.shoppingList.dto;

import lombok.*;
import shopping.list.manager.shoppinglistservice.shoppingList.entity.enums.Status;

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
