package shopping.list.manager.userservice.user.initialize;

import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shopping.list.manager.userservice.user.entity.User;
import shopping.list.manager.userservice.user.service.api.UserService;

import java.time.LocalDate;
import java.util.UUID;

@Component
@Log
public class InitializeData implements InitializingBean {

    private final UserService userService;

    @Autowired
    public InitializeData(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void afterPropertiesSet() {
        log.info("Initializing data...");
        User user1 = User.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .email("marekandrysiak@wp.pl")
                .password("password1")
                .name("Marek")
                .surname("Patka")
                .birthDate(LocalDate.of(1990, 5, 15))
                .build();

        User user2 = User.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a7"))
                .email("jerzykondysiak@gmail.com")
                .password("password2")
                .name("Jerzy")
                .surname("Kondys")
                .birthDate(LocalDate.of(1995, 10, 20))
                .build();

        User user3 = User.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a8"))
                .email("patrykgrzyb@o2.pl")
                .password("password3")
                .name("Patryk")
                .surname("Grzyb")
                .birthDate(LocalDate.of(2000, 12, 25))
                .build();

        userService.create(user1);
        userService.create(user2);
        userService.create(user3);
        log.info("User Data initialized");
    }

}
