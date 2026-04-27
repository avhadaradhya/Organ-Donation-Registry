package com.organdonation.registry.repository;

import com.organdonation.registry.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    // Custom method to find a user by their username
    AppUser findByUsername(String username);
}