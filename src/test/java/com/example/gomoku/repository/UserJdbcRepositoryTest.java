package com.example.gomoku.repository;

import com.example.gomoku.user.User;
import com.example.gomoku.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserJdbcRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    @DisplayName("User 회원가입 정보가 정상적으로 저장됩니다")
    void insert() {
        // given
        User user = new User("superstring7@gmail.com", "ckdwh723!", "이동준");
        userRepository.insert(user);

        // when
        var retrievedUser = userRepository.findByEmail(user.getEmail());

        // then
        assertThat(retrievedUser).isNotEmpty();
        assertThat(retrievedUser.get()).usingRecursiveComparison().isEqualTo(user);
    }
}