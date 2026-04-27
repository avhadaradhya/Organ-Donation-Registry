package com.organdonation.registry.service;

import com.organdonation.registry.model.Donor;
import com.organdonation.registry.model.Recipient;
import com.organdonation.registry.repository.DonorRepository;
import com.organdonation.registry.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrganMatchingService {

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    // This background thread runs every 30 seconds (30000 ms)
    @Scheduled(fixedRate = 30000)
    public void runMatchingEngine() {
        System.out.println("Matching Engine: Scanning for new compatibility matches...");

        List<Donor> donors = donorRepository.findAll();
        List<Recipient> recipients = recipientRepository.findAll();

        for (Recipient recipient : recipients) {
            for (Donor donor : donors) {
                // Logic: Match by Organ Type AND Blood Group
                if (recipient.getRequiredOrgan().equalsIgnoreCase(donor.getOrganPledged()) &&
                    recipient.getRequiredBloodGroup().equalsIgnoreCase(donor.getBloodGroup())) {
                    
                    System.out.println("MATCH FOUND: Donor " + donor.getFullName() + 
                                       " for Recipient " + recipient.getFullName());
                    
                    // Trigger a separate thread for notifications (CO1 requirement)
                    sendNotificationAsync(donor.getFullName(), recipient.getFullName());
                }
            }
        }
    }

    @Async
    public void sendNotificationAsync(String donorName, String recipientName) {
        // Simulates a time-consuming background process like sending an email/SMS
        try {
            System.out.println("Async Thread [" + Thread.currentThread().getName() + 
                               "]: Sending alerts for match...");
            Thread.sleep(2000); 
            System.out.println("Alerts sent successfully for " + donorName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}