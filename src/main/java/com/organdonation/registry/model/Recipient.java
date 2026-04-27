package com.organdonation.registry.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "recipients")
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String requiredBloodGroup;
    private String requiredTissueType;
    private String requiredOrgan;
    private String urgencyLevel; // e.g., HIGH, MEDIUM, LOW
    private LocalDate requestDate;

    public Recipient() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getRequiredBloodGroup() { return requiredBloodGroup; }
    public void setRequiredBloodGroup(String requiredBloodGroup) { this.requiredBloodGroup = requiredBloodGroup; }
    public String getRequiredTissueType() { return requiredTissueType; }
    public void setRequiredTissueType(String requiredTissueType) { this.requiredTissueType = requiredTissueType; }
    public String getRequiredOrgan() { return requiredOrgan; }
    public void setRequiredOrgan(String requiredOrgan) { this.requiredOrgan = requiredOrgan; }
    public String getUrgencyLevel() { return urgencyLevel; }
    public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }
    public LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }
}