package shopping.list.manager.userservice.user.controller.impl;

import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import shopping.list.manager.userservice.user.controller.api.UserController;
import shopping.list.manager.userservice.user.dto.GetUserResponse;
import shopping.list.manager.userservice.user.dto.GetUsersResponse;
import shopping.list.manager.userservice.user.dto.PatchUserRequest;
import shopping.list.manager.userservice.user.dto.PutUserRequest;
import shopping.list.manager.userservice.user.function.RequestToUserFunction;
import shopping.list.manager.userservice.user.function.UpdateUserWithRequestFunction;
import shopping.list.manager.userservice.user.function.UserToResponseFunction;
import shopping.list.manager.userservice.user.function.UsersToResponseFunction;
import shopping.list.manager.userservice.user.service.api.UserService;

import java.util.UUID;

@RestController
@Log
public class UserDefaultController implements UserController {

    private final UserService service;
    private final UserToResponseFunction userToResponse;
    private final UsersToResponseFunction usersToResponse;
    private final RequestToUserFunction requestToUser;
    private final UpdateUserWithRequestFunction updateUser;
    private final UpdateUserWithRequestFunction updateUserWithRequestFunction;

    @Autowired
    public UserDefaultController(UserService service,
                                 UserToResponseFunction userToResponse,
                                 UsersToResponseFunction usersToResponse,
                                 RequestToUserFunction requestToUser,
                                 UpdateUserWithRequestFunction updateUser, UpdateUserWithRequestFunction updateUserWithRequestFunction) {
        this.service = service;
        this.userToResponse = userToResponse;
        this.usersToResponse = usersToResponse;
        this.requestToUser = requestToUser;
        this.updateUser = updateUser;
        this.updateUserWithRequestFunction = updateUserWithRequestFunction;
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

    @Override
    public void patchUser(UUID id, PatchUserRequest request) {
        service.update(updateUserWithRequestFunction.apply(service.find(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), request));
    }
}
