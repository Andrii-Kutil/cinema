package com.gmail.kutilandrej.cinema.service;

import com.gmail.kutilandrej.cinema.exception.AuthenticationException;
import com.gmail.kutilandrej.cinema.model.User;

public interface AuthenticationService {
    User registration(String email, String login, String password) throws AuthenticationException;
}
