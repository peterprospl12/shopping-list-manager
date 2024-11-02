package shopping.list.manager.userservice.user.controller.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import shopping.list.manager.userservice.user.dto.GetUserResponse;
import shopping.list.manager.userservice.user.dto.GetUsersResponse;
import shopping.list.manager.userservice.user.dto.PatchUserRequest;
import shopping.list.manager.userservice.user.dto.PutUserRequest;

import java.util.UUID;

public interface UserController {

    @GetMapping("api/users")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetUsersResponse getUsers();

    @GetMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetUserResponse getUser(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putUser(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutUserRequest request
    );

    @PatchMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchUser(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchUserRequest request
    );

}