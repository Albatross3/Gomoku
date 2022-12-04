package com.example.gomoku.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void insert(User user);

    List<User> findAll();

    Optional<User> findByEmail(String email);
}
