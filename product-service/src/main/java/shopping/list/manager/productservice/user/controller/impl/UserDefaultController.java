package shopping.list.manager.productservice.user.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import shopping.list.manager.productservice.user.controller.api.UserController;
import shopping.list.manager.productservice.user.service.api.UserService;

import java.util.UUID;

@RestController
@Log
public class UserDefaultController implements UserController {
    private final UserService service;

    @Autowired
    public UserDefaultController(UserService service) {
        this.service = service;
    }

    @Override
    public void deleteUser(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        user -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
