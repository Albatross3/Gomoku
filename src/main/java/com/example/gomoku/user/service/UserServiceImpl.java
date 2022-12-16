package com.example.gomoku.user.service;

import com.example.gomoku.user.User;
import com.example.gomoku.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(String email, String password, String name) {
        // service 계층에서 암호화를 시켜주고 있다
        String encodedPassword = passwordEncoder.encode(password);
        userRepository.save(new User(email, encodedPassword, name));
    }

}
