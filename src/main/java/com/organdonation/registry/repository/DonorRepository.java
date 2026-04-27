package com.organdonation.registry.repository;

import com.organdonation.registry.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
    // Spring Data JPA automatically provides methods like save(), findAll(), and findById()
}