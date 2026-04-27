package com.organdonation.registry;

import com.organdonation.registry.model.AppUser;
import com.organdonation.registry.repository.UserRepository;
import com.organdonation.registry.service.JdbcFallbackService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class RegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, 
                                      PasswordEncoder passwordEncoder,
                                      JdbcFallbackService jdbcService) {
        return args -> {
            // 1. Create Admin if missing
            if (userRepository.findByUsername("admin") == null) {
                AppUser admin = new AppUser();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
                System.out.println("Default Admin User created!");
            }
            
            // 2. Demonstrate the JDBC PreparedStatement Fallback
            System.out.println("Running JDBC Fallback Operation...");
            jdbcService.bulkUpdateUrgencyLevel("O-", "CRITICAL");
        };
    }
}