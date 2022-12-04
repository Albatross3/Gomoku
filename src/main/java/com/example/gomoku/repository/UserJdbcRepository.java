package com.example.gomoku.repository;

import com.example.gomoku.user.User;
import com.example.gomoku.user.UserRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserJdbcRepository implements UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Map<String, Object> toParamMap(User user) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", user.getEmail());
        paramMap.put("password", user.getPassword());
        paramMap.put("name", user.getName());
        return paramMap;
    }

    private final RowMapper<User> rowMapper = ((rs, rowNum) -> {
        String email = rs.getString("email");
        String password = rs.getString("password");
        String name = rs.getString("name");
        return new User(email, password, name);
    });

    @Override
    public void insert(User user) {
        jdbcTemplate.update("INSERT INTO test_user(email, password, name) " +
                "VALUES(:email, :password, :name)", toParamMap(user));
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM test_user", rowMapper);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(
                jdbcTemplate.queryForObject("SELECT * FROM test_user WHERE email = :email"
                        , Collections.singletonMap("email", email)
                        , rowMapper)
        );
    }
}
