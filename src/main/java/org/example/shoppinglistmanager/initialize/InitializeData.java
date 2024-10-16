package org.example.shoppinglistmanager.initialize;

import org.example.shoppinglistmanager.entity.Product;
import org.example.shoppinglistmanager.entity.ShoppingList;
import org.example.shoppinglistmanager.entity.User;
import org.example.shoppinglistmanager.entity.enums.Category;
import org.example.shoppinglistmanager.entity.enums.Status;
import org.example.shoppinglistmanager.service.api.ProductService;
import org.example.shoppinglistmanager.service.api.ShoppingListService;
import org.example.shoppinglistmanager.service.api.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class InitializeData  implements InitializingBean {

    private final UserService userService;
    private final ShoppingListService shoppingListService;
    private final ProductService productService;

    @Autowired
    public InitializeData(UserService userService, ShoppingListService shoppingListService, ProductService productService) {
        this.userService = userService;
        this.shoppingListService = shoppingListService;
        this.productService = productService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Product product1 = Product.builder().
                id(UUID.randomUUID())
                .name("Product1")
                .category(Category.DRINKS)
                .price(10)
                .quantity(2)
                .isBought(false)
                .build();

        Product product2 = Product.builder()
                .id(UUID.randomUUID())
                .name("Product2")
                .category(Category.FOOD)
                .price(20)
                .quantity(3)
                .isBought(true)
                .build();

        Product product3 = Product.builder()
                .id(UUID.randomUUID())
                .name("Product3")
                .category(Category.HOUSEHOLD)
                .price(30)
                .quantity(4)
                .isBought(false)
                .build();

        Product product4 = Product.builder()
                .id(UUID.randomUUID())
                .name("Product4")
                .category(Category.OTHER)
                .price(40)
                .quantity(5)
                .isBought(true)
                .build();

        Product product5 = Product.builder()
                .id(UUID.randomUUID())
                .name("Product5")
                .category(Category.DRINKS)
                .price(50)
                .quantity(6)
                .isBought(false)
                .build();

        productService.create(product1);
        productService.create(product2);
        productService.create(product3);
        productService.create(product4);
        productService.create(product5);

        ShoppingList shoppingList1 = ShoppingList.builder().id(UUID.randomUUID()).name("List1224").date(LocalDate.ofYearDay(2024, 13)).status(Status.ACTIVE).build();
        ShoppingList shoppingList2 = ShoppingList.builder().id(UUID.randomUUID()).name("List255").date(LocalDate.ofYearDay(1995,15)).status(Status.ACTIVE).build();
        ShoppingList shoppingList3 = ShoppingList.builder().id(UUID.randomUUID()).name("List311").date(LocalDate.ofYearDay(2000, 25)).status(Status.ARCHIVED).build();


    }
}
