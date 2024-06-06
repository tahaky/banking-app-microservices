package com.bankingapp.userservice.controller;

import com.bankingapp.userservice.model.dto.UserDto;
import com.bankingapp.userservice.model.request.UserUpdateRequest;
import com.bankingapp.userservice.service.IKeycloakUserService;
import com.bankingapp.userservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/bank-user")
@RequiredArgsConstructor
public class UserController {
    private final IKeycloakUserService keycloakUserService;
    private final IUserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> createUser(@RequestBody UserDto request) {
        log.info("Creating user with {}", request.toString());
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") UUID userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        log.info("Updating user with {}", userUpdateRequest.toString());
        return ResponseEntity.ok(userService.updateUser(userId, userUpdateRequest));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> readUsers() {
        log.info("Reading all users from API");
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> readUser(@PathVariable("id") UUID id) {
        log.info("Reading user by id {}", id);
        return ResponseEntity.ok(userService.getUser(id));
    }
}
