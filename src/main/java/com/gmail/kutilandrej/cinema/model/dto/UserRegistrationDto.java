package com.gmail.kutilandrej.cinema.model.dto;

import com.gmail.kutilandrej.cinema.lib.EmailConstraint;
import com.gmail.kutilandrej.cinema.lib.PasswordConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordConstraint
public class UserRegistrationDto {
    @NotNull
    @EmailConstraint
    @Size(min = 5, max = 100)
    private String email;
    @NotNull
    private String login;
    @Size(min = 4)
    private String password;
    private String repeatedPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
