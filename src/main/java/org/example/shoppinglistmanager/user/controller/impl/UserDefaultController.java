package org.example.shoppinglistmanager.user.controller.impl;

import lombok.extern.java.Log;
import org.example.shoppinglistmanager.user.controller.api.UserController;
import org.example.shoppinglistmanager.user.dto.GetUserResponse;
import org.example.shoppinglistmanager.user.dto.GetUsersResponse;
import org.example.shoppinglistmanager.user.dto.PutUserRequest;
import org.example.shoppinglistmanager.user.function.RequestToUserFunction;
import org.example.shoppinglistmanager.user.function.UserToResponseFunction;
import org.example.shoppinglistmanager.user.function.UsersToResponseFunction;
import org.example.shoppinglistmanager.user.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class UserDefaultController implements UserController {

    private final UserService service;
    private final UserToResponseFunction userToResponse;
    private final UsersToResponseFunction usersToResponse;
    private final RequestToUserFunction requestToUser;

    @Autowired
    public UserDefaultController(UserService service,
                                 UserToResponseFunction userToResponse,
                                 UsersToResponseFunction usersToResponse,
                                 RequestToUserFunction requestToUser) {
        this.service = service;
        this.userToResponse = userToResponse;
        this.usersToResponse = usersToResponse;
        this.requestToUser = requestToUser;
    }

    @Override
    public GetUsersResponse getUsers() {
        return usersToResponse.apply(service.findAll());
    }

    @Override
    public GetUserResponse getUser(UUID id) {
        return service.find(id)
                .map(userToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteUser(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        user -> {
                            service.delete(id);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void putUser(UUID id, PutUserRequest request) {
        service.create(requestToUser.apply(id, request));
    }
}
