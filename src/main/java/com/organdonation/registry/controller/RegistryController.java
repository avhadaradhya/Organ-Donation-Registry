package com.organdonation.registry.controller;

import com.organdonation.registry.model.*;
import com.organdonation.registry.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class RegistryController {

    @Autowired private DonorRepository donorRepository;
    @Autowired private RecipientRepository recipientRepository;
    @Autowired private HospitalRepository hospitalRepository;
    @Autowired private OrganMatchRepository matchRepository;

    @GetMapping("/")
    public String showHomePage(Model model) {
        // Prepare empty objects for the forms
        model.addAttribute("donor", new Donor());
        model.addAttribute("recipient", new Recipient());
        model.addAttribute("hospital", new Hospital());

        // Fetch data to display in tables
        model.addAttribute("donorsList", donorRepository.findAll());
        model.addAttribute("recipientsList", recipientRepository.findAll());
        model.addAttribute("hospitalsList", hospitalRepository.findAll());
        model.addAttribute("matchesList", matchRepository.findAll());
        
        return "index";
    }

    @PostMapping("/addDonor")
    public String saveDonor(@ModelAttribute("donor") Donor donor) {
        donor.setRegistrationDate(LocalDate.now());
        donorRepository.save(donor);
        return "redirect:/";
    }

    @PostMapping("/addRecipient")
    public String saveRecipient(@ModelAttribute("recipient") Recipient recipient) {
        recipient.setRequestDate(LocalDate.now());
        recipientRepository.save(recipient);
        return "redirect:/";
    }

    @PostMapping("/addHospital")
    public String saveHospital(@ModelAttribute("hospital") Hospital hospital) {
        hospitalRepository.save(hospital);
        return "redirect:/";
    }
}