package com.example.enanospeleadores2.users.controller;

import com.example.enanospeleadores2.users.dto.UserResponseDTO;
import com.example.enanospeleadores2.users.dto.UserUpdateDTO;
import com.example.enanospeleadores2.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponseDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public UserResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody UserUpdateDTO dto
    ) {
        return userService.update(id, dto);
    }
}