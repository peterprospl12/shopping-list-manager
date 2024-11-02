package shopping.list.manager.productservice.product.initialize;

import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shopping.list.manager.productservice.product.entity.Product;
import shopping.list.manager.productservice.product.entity.enums.Category;
import shopping.list.manager.productservice.product.service.api.ProductService;
import shopping.list.manager.productservice.shoppingList.entity.ShoppingList;
import shopping.list.manager.productservice.shoppingList.service.api.ShoppingListService;
import shopping.list.manager.productservice.user.entity.User;
import shopping.list.manager.productservice.user.service.api.UserService;

import java.util.UUID;

@Component
@Log
public class InitializeData implements InitializingBean {

    private final ProductService productService;

    private final ShoppingListService shoppingListService;

    private final UserService userService;

    @Autowired
    public InitializeData(ProductService productService, ShoppingListService shoppingListService, UserService userService) {
        this.productService = productService;
        this.shoppingListService = shoppingListService;
        this.userService = userService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Initializing data...");

        if (productService.findAll().isEmpty()) {
            User user1 = User.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                    .build();

            User user2 = User.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a7"))
                    .build();

            User user3 = User.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a8"))
                    .build();

            userService.create(user1);
            userService.create(user2);
            userService.create(user3);

            log.info("User Data initialized");

            ShoppingList shoppingList1 = ShoppingList.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a9"))
                    .build();

            ShoppingList shoppingList2 = ShoppingList.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b0"))
                    .build();

            ShoppingList shoppingList3 = ShoppingList.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b1"))
                    .build();

            shoppingListService.create(shoppingList1);
            shoppingListService.create(shoppingList2);
            shoppingListService.create(shoppingList3);

            log.info("Shopping List Data initialized");

            Product product1 = Product.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b2"))
                    .name("Product1")
                    .category(Category.DRINKS)
                    .price(10)
                    .quantity(2)
                    .isBought(false)
                    .shoppingList(shoppingList1)
                    .user(user1)
                    .build();

            Product product2 = Product.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b3"))
                    .name("Product2")
                    .category(Category.FOOD)
                    .price(20)
                    .quantity(3)
                    .isBought(true)
                    .shoppingList(shoppingList1)
                    .user(user1)
                    .build();

            Product product3 = Product.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b4"))
                    .name("Product3")
                    .category(Category.HOUSEHOLD)
                    .price(30)
                    .quantity(4)
                    .isBought(false)
                    .shoppingList(shoppingList2)
                    .user(user2)
                    .build();

            Product product4 = Product.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b5"))
                    .name("Product4")
                    .category(Category.OTHER)
                    .price(40)
                    .quantity(5)
                    .isBought(true)
                    .shoppingList(shoppingList2)
                    .user(user2)
                    .build();

            Product product5 = Product.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b6"))
                    .name("Product5")
                    .category(Category.DRINKS)
                    .price(50)
                    .quantity(6)
                    .isBought(false)
                    .shoppingList(shoppingList3)
                    .user(user3)
                    .build();

            productService.create(product1);
            productService.create(product2);
            productService.create(product3);
            productService.create(product4);
            productService.create(product5);

            log.info("Product Data initialized");
        }

        log.info("Data initialized");
    }

}
