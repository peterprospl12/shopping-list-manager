package shopping.list.manager.shoppinglistservice.shoppingList.initialize;

import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shopping.list.manager.shoppinglistservice.shoppingList.entity.ShoppingList;
import shopping.list.manager.shoppinglistservice.shoppingList.entity.enums.Status;
import shopping.list.manager.shoppinglistservice.shoppingList.service.api.ShoppingListService;

import java.time.LocalDate;
import java.util.UUID;

@Component
@Log
public class InitializeData implements InitializingBean {

    private final ShoppingListService shoppingListService;

    @Autowired
    public InitializeData(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Initializing data...");
        ShoppingList shoppingList1 = ShoppingList.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a9"))
                .name("List1224")
                .date(LocalDate.ofYearDay(2024, 13))
                .status(Status.ACTIVE)
                .build();

        ShoppingList shoppingList2 = ShoppingList.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b0"))
                .name("List255")
                .date(LocalDate.ofYearDay(1995,15))
                .status(Status.ACTIVE)
                .build();

        ShoppingList shoppingList3 = ShoppingList.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00b1"))
                .name("List311")
                .date(LocalDate.ofYearDay(2000, 25))
                .status(Status.ARCHIVED)
                .build();

        shoppingListService.create(shoppingList1);
        shoppingListService.create(shoppingList2);
        shoppingListService.create(shoppingList3);
        log.info("User Data initialized");
    }

}
