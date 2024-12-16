package shopping.list.manager.productservice.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import shopping.list.manager.productservice.product.entity.enums.Category;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetProductResponse {

    private UUID id;
    private String name;
    private Category category;
    private double price;
    private int quantity;
    @JsonProperty("isBought")
    private boolean isBought;
    private UUID shoppingListId;
}
