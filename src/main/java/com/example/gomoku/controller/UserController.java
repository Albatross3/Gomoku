package com.example.gomoku.controller;

import com.example.gomoku.controller.dto.SignUpRequest;
import com.example.gomoku.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String viewSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(SignUpRequest signUpRequest) {
        userService.register(signUpRequest.email(),signUpRequest.password(), signUpRequest.name());
        return "redirect:/login";
    }
}
