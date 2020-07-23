package com.gmail.kutilandrej.cinema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/registration")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/movies", "/cinema-halls",
                        "/movie-sessions/available/**")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/shopping-carts/by-user/**", "/orders")
                .hasRole("USER")
                .antMatchers(HttpMethod.POST, "/shopping-carts/add-movie-session",
                        "/orders/complete").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/users/by-email/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/movies", "/cinema-halls", "/movie-sessions")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
