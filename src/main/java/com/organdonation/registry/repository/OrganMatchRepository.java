package com.organdonation.registry.repository;

import com.organdonation.registry.model.OrganMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganMatchRepository extends JpaRepository<OrganMatch, Long> {
}