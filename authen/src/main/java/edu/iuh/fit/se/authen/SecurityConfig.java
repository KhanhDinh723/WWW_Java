package edu.iuh.fit.se.authen;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author: Khánh Đinh
 * Date:   11/9/2025
 * Time:   4:37 PM
 */
public class SecurityConfig {
    @Bean
    public PasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
