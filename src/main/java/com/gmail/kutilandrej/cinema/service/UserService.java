package com.gmail.kutilandrej.cinema.service;

import com.gmail.kutilandrej.cinema.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> getByEmail(String email);

    User getById(Long id);
}
