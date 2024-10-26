package org.example.shoppinglistmanager.initialize;

import org.example.shoppinglistmanager.shoppingList.entity.Product;
import org.example.shoppinglistmanager.shoppingList.entity.ShoppingList;
import org.example.shoppinglistmanager.user.entity.User;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Category;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Status;
import org.example.shoppinglistmanager.shoppingList.service.api.ProductService;
import org.example.shoppinglistmanager.shoppingList.service.api.ShoppingListService;
import org.example.shoppinglistmanager.user.service.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

@Component
public class InitializeData  implements InitializingBean {

    private final UserService userService;
    private final ShoppingListService shoppingListService;
    private final ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(InitializeData.class);

    @Autowired
    public InitializeData(UserService userService, ShoppingListService shoppingListService, ProductService productService) {
        this.userService = userService;
        this.shoppingListService = shoppingListService;
        this.productService = productService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Initializing data...");

        User user1 = User.builder()
                .email("marekandrysiak@wp.pl")
                .password("password1")
                .name("Marek")
                .surname("Patka")
                .birthDate(LocalDate.of(1990, 5, 15))
                .build();

        User user2 = User.builder()
                .email("jerzykondysiak@gmail.com")
                .password("password2")
                .name("Jerzy")
                .surname("Kondys")
                .birthDate(LocalDate.of(1995, 10, 20))
                .build();

        User user3 = User.builder()
                .email("patrykgrzyb@o2.pl")
                .password("password3")
                .name("Patryk")
                .surname("Grzyb")
                .birthDate(LocalDate.of(2000, 12, 25))
                .build();

        ShoppingList shoppingList1 = ShoppingList.builder()
                .name("List1224")
                .date(LocalDate.ofYearDay(2024, 13))
                .status(Status.ACTIVE)
                .user(user1)
                .build();
        user1.getShoppingLists().add(shoppingList1);

        ShoppingList shoppingList2 = ShoppingList.builder()
                .name("List255")
                .date(LocalDate.ofYearDay(1995,15))
                .status(Status.ACTIVE)
                .user(user2)
                .build();
        user2.getShoppingLists().add(shoppingList2);

        ShoppingList shoppingList3 = ShoppingList.builder()
                .name("List311")
                .date(LocalDate.ofYearDay(2000, 25))
                .status(Status.ARCHIVED)
                .user(user3)
                .build();
        user3.getShoppingLists().add(shoppingList3);

        Product product1 = Product.builder()
                .name("Product1")
                .category(Category.DRINKS)
                .price(10)
                .quantity(2)
                .isBought(false)
                .shoppingList(shoppingList1)
                .build();
        shoppingList1.getProducts().add(product1);

        Product product2 = Product.builder()
                .name("Product2")
                .category(Category.FOOD)
                .price(20)
                .quantity(3)
                .isBought(true)
                .shoppingList(shoppingList1)
                .build();
        shoppingList1.getProducts().add(product2);

        Product product3 = Product.builder()
                .name("Product3")
                .category(Category.HOUSEHOLD)
                .price(30)
                .quantity(4)
                .isBought(false)
                .shoppingList(shoppingList2)
                .build();
        shoppingList2.getProducts().add(product3);

        Product product4 = Product.builder()
                .name("Product4")
                .category(Category.OTHER)
                .price(40)
                .quantity(5)
                .isBought(true)
                .shoppingList(shoppingList2)
                .build();
        shoppingList2.getProducts().add(product4);

        Product product5 = Product.builder()
                .name("Product5")
                .category(Category.DRINKS)
                .price(50)
                .quantity(6)
                .isBought(false)
                .shoppingList(shoppingList3)
                .build();
        shoppingList3.getProducts().add(product5);

        logger.info("Data initialized successfully");

        userService.create(user1);
        userService.create(user2);
        userService.create(user3);

        shoppingListService.create(shoppingList3);
        shoppingListService.create(shoppingList1);
        shoppingListService.create(shoppingList2);

        productService.create(product1);
        productService.create(product2);
        productService.create(product3);
        productService.create(product4);
        productService.create(product5);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("uuids.txt"))) {
            writer.write("User1: " + user1.getId() + "\n");
            writer.write("User2: " + user2.getId() + "\n");
            writer.write("User3: " + user3.getId() + "\n");
            writer.write("ShoppingList1: " + shoppingList1.getId() + "\n");
            writer.write("ShoppingList2: " + shoppingList2.getId() + "\n");
            writer.write("ShoppingList3: " + shoppingList3.getId() + "\n");
            writer.write("Product1: " + product1.getId() + "\n");
            writer.write("Product2: " + product2.getId() + "\n");
            writer.write("Product3: " + product3.getId() + "\n");
            writer.write("Product4: " + product4.getId() + "\n");
            writer.write("Product5: " + product5.getId() + "\n");
        } catch (IOException e) {
            logger.error("Error writing UUIDs to file", e);
        }
        logger.info("Data saved successfully");
    }

}
