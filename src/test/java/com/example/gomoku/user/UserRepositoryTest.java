package com.example.gomoku.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("저장이 정상적으로 되는지 확인")
    void save() {
        User user = new User();
        user.setEmail("superstring77@gmail.com");
        user.setPassword("ckdwh723!");
        user.setName("이동준");

        userRepository.save(user); // 영속성 컨텍스트에 들어감, id 값을 DB 에서 가져옴

        User entity = userRepository.findById(user.getId()).get();

        Assertions.assertThat(user).usingRecursiveComparison().isEqualTo(entity);
    }
}