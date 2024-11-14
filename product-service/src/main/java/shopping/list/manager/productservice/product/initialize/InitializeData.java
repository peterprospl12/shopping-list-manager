package shopping.list.manager.productservice.product.initialize;

import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shopping.list.manager.productservice.product.entity.Product;
import shopping.list.manager.productservice.product.entity.enums.Category;
import shopping.list.manager.productservice.product.service.api.ProductService;

import java.util.UUID;

@Component
@Log
public class InitializeData implements InitializingBean {

    private final ProductService productService;

    @Autowired
    public InitializeData(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Initializing data...");

        if (productService.findAll().isEmpty()) {
            Product product1 = Product.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b2"))
                    .name("Product1")
                    .category(Category.DRINKS)
                    .price(10)
                    .quantity(2)
                    .isBought(false)
                    .shoppingListId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a9"))
                    .userId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                    .build();

            Product product2 = Product.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b3"))
                    .name("Product2")
                    .category(Category.FOOD)
                    .price(20)
                    .quantity(3)
                    .isBought(true)
                    .shoppingListId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a9"))
                    .userId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                    .build();

            Product product3 = Product.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b4"))
                    .name("Product3")
                    .category(Category.HOUSEHOLD)
                    .price(30)
                    .quantity(4)
                    .isBought(false)
                    .shoppingListId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b0"))
                    .userId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a7"))
                    .build();

            Product product4 = Product.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b5"))
                    .name("Product4")
                    .category(Category.OTHER)
                    .price(40)
                    .quantity(5)
                    .isBought(true)
                    .shoppingListId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b0"))
                    .userId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a7"))
                    .build();

            Product product5 = Product.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b6"))
                    .name("Product5")
                    .category(Category.DRINKS)
                    .price(50)
                    .quantity(6)
                    .isBought(false)
                    .shoppingListId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b1"))
                    .userId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a8"))
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
