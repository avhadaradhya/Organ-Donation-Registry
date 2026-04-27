package com.organdonation.registry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class JdbcFallbackService {

    // Spring Boot automatically configures this DataSource to connect to your MySQL DB
    @Autowired
    private DataSource dataSource;

    public void bulkUpdateUrgencyLevel(String bloodGroup, String newUrgencyLevel) {
        // Raw SQL query with placeholders (?) for security against SQL Injection
        String sql = "UPDATE recipients SET urgency_level = ? WHERE required_blood_group = ?";
        
        // Using standard JDBC connection and PreparedStatement
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Set the parameters
            pstmt.setString(1, newUrgencyLevel);
            pstmt.setString(2, bloodGroup);
            
            // Execute the raw query
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("JDBC PreparedStatement Executed! Recipients updated: " + rowsAffected);
            
        } catch (SQLException e) {
            System.out.println("JDBC Error: " + e.getMessage());
        }
    }
}