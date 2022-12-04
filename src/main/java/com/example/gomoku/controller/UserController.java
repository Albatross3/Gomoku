package com.example.gomoku.controller;

import com.example.gomoku.user.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/user")
//    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {
//        userService.register(signUpRequest.getEmail(), signUpRequest.getPassword());
//    }
}
