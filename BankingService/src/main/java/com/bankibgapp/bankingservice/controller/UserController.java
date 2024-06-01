package com.bankibgapp.bankingservice.controller;

import com.bankibgapp.bankingservice.model.dto.UserDto;
import com.bankibgapp.bankingservice.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public ResponseEntity<List<UserDto>> readUser() {
        return ResponseEntity.ok(userService.readUsers());
    }

    @GetMapping("/{identification}")
    public ResponseEntity<UserDto> readUser(@PathVariable("identification") String identification) {
        return ResponseEntity.ok(userService.readUser(identification));
    }
}
