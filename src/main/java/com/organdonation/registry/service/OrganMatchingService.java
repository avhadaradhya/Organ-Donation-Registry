package com.organdonation.registry.service;

import com.organdonation.registry.model.*;
import com.organdonation.registry.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrganMatchingService {

    @Autowired private DonorRepository donorRepository;
    @Autowired private RecipientRepository recipientRepository;
    @Autowired private OrganMatchRepository matchRepository; // Add this

    @Scheduled(fixedRate = 30000)
    public void runMatchingEngine() {
        System.out.println("Matching Engine: Scanning for new compatibility matches...");
        List<Donor> donors = donorRepository.findAll();
        List<Recipient> recipients = recipientRepository.findAll();

        for (Recipient recipient : recipients) {
            for (Donor donor : donors) {
                // Compatibility Logic: Organ + Blood Group Match
                if (recipient.getRequiredOrgan().equalsIgnoreCase(donor.getOrganPledged()) &&
                    recipient.getRequiredBloodGroup().equalsIgnoreCase(donor.getBloodGroup())) {
                    
                    // CRITICAL: Check if this match already exists in our table to avoid duplicates
                    boolean alreadyMatched = matchRepository.findAll().stream()
                        .anyMatch(m -> m.getDonor().getId().equals(donor.getId()) && 
                                       m.getRecipient().getId().equals(recipient.getId()));

                    if (!alreadyMatched) {
                        OrganMatch match = new OrganMatch();
                        match.setDonor(donor);
                        match.setRecipient(recipient);
                        match.setMatchDate(LocalDateTime.now());
                        match.setStatus("COMPATIBLE");
                        
                        matchRepository.save(match); // This saves it to the MySQL 'organ_matches' table
                        System.out.println("DATABASE UPDATED: New match saved for " + recipient.getFullName());
                        sendNotificationAsync(donor.getFullName(), recipient.getFullName());
                    }
                }
            }
        }
    }

    @Async
    public void sendNotificationAsync(String donorName, String recipientName) {
        try {
            Thread.sleep(2000); 
            System.out.println("Async Notification sent for match: " + donorName + " -> " + recipientName);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}