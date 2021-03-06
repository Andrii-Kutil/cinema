package com.gmail.kutilandrej.cinema.service.impl;

import com.gmail.kutilandrej.cinema.dao.UserDao;
import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public User getById(Long id) {
        return userDao.get(id);
    }
}
