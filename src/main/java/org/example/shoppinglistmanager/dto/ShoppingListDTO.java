package org.example.shoppinglistmanager.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingListDTO {
    private String id;
    private String name;
    private LocalDate date;
    private String status;
    private String userId;
    private List<ProductDTO> products;
}
