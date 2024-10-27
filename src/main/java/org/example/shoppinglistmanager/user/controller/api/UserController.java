package org.example.shoppinglistmanager.user.controller.api;

import org.example.shoppinglistmanager.user.dto.GetUserResponse;
import org.example.shoppinglistmanager.user.dto.GetUsersResponse;
import org.example.shoppinglistmanager.user.dto.PutUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}