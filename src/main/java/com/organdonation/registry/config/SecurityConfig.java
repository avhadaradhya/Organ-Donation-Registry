package com.organdonation.registry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // This encrypts passwords so they aren't saved as plain text in your database
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // This defines our access rules
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/").hasRole("ADMIN") // Only Admins can see the dashboard
                .anyRequest().authenticated()
            )
            .formLogin(form -> form.permitAll()) // Uses Spring's default login page
            .logout(logout -> logout.permitAll())
            .csrf(csrf -> csrf.disable()); // Disabled strictly for simplicity in this student project
            
        return http.build();
    }
}