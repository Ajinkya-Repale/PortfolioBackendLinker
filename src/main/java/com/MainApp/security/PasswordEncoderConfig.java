package com.MainApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Separated from SecurityConfig to avoid circular dependency:
 *
 * SecurityConfig → CustomAdminDetailsService → PasswordEncoder → SecurityConfig (loop!)
 *
 * By moving PasswordEncoder to its own config class, Spring can
 * instantiate it independently before building the security chain.
 */
@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}