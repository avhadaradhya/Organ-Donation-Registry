package com.organdonation.registry.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "organ_matches")
public class OrganMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Establishing Foreign Keys
    @ManyToOne
    @JoinColumn(name = "donor_id", nullable = false)
    private Donor donor;

    @ManyToOne
    @JoinColumn(name = "recipient_id", nullable = false)
    private Recipient recipient;

    private LocalDateTime matchDate;
    private String status; // e.g., "PENDING_HOSPITAL_APPROVAL", "COMPLETED"

    public OrganMatch() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Donor getDonor() { return donor; }
    public void setDonor(Donor donor) { this.donor = donor; }
    public Recipient getRecipient() { return recipient; }
    public void setRecipient(Recipient recipient) { this.recipient = recipient; }
    public LocalDateTime getMatchDate() { return matchDate; }
    public void setMatchDate(LocalDateTime matchDate) { this.matchDate = matchDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}