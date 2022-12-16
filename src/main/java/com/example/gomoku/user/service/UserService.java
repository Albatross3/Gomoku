package com.example.gomoku.user.service;


import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void register(String email, String password, String nickname);

}
