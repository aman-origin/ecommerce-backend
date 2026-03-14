package com.aman.ecommerce.user.controller;

import com.aman.ecommerce.user.dto.RegisterUserRequest;
import com.aman.ecommerce.user.dto.UserResponse;
import com.aman.ecommerce.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponse registerUser(
            @Valid @RequestBody RegisterUserRequest request
    ) {
        return userService.registerUser(request);
    }
}