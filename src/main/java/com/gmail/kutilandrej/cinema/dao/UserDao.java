package com.gmail.kutilandrej.cinema.dao;

import com.gmail.kutilandrej.cinema.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> getByEmail(String email);

    User get(Long userId);
}
