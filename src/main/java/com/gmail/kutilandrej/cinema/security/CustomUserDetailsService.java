package com.gmail.kutilandrej.cinema.security;

import com.gmail.kutilandrej.cinema.model.User;
import com.gmail.kutilandrej.cinema.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(s);
        UserBuilder builder;
        if (user.isPresent()) {
            builder = org.springframework.security.core.userdetails.User.withUsername(s);
            builder.password(user.get().getPassword());
            String[] roles = user.get().getRoles().stream()
                    .map(role -> role.getRoleName().name())
                    .toArray(String[]::new);
            builder.roles(roles);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}
