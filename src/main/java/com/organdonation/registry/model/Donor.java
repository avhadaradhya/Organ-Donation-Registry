package com.organdonation.registry.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donors")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String bloodGroup; // e.g., A+, O-
    private String tissueType; // For the matching engine requirement
    private String organPledged; 
    private LocalDate registrationDate;
    
    // Default constructor required by Hibernate
    public Donor() {}

    // Getters and Setters (You can generate these in Eclipse: Right-click -> Source -> Generate Getters and Setters)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public String getTissueType() { return tissueType; }
    public void setTissueType(String tissueType) { this.tissueType = tissueType; }
    public String getOrganPledged() { return organPledged; }
    public void setOrganPledged(String organPledged) { this.organPledged = organPledged; }
    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }
}