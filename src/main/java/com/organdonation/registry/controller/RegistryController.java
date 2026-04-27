package com.organdonation.registry.controller;

import com.organdonation.registry.model.Donor;
import com.organdonation.registry.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class RegistryController {

    @Autowired
    private DonorRepository donorRepository;

    // This method handles displaying the webpage when you visit the site
    @GetMapping("/")
    public String showHomePage(Model model) {
        // Creates an empty Donor object to bind to our HTML form
    	model.addAttribute("donor", new Donor());        // Fetches all donors to display on the dashboard
        model.addAttribute("donorsList", donorRepository.findAll());
        return "index"; // This tells Spring to look for index.html
    }

    // This method handles the form submission when you click "Save"
    @PostMapping("/addDonor")
    public String saveDonor(@ModelAttribute("donor") Donor donor) {
        donor.setRegistrationDate(LocalDate.now()); // Set today's date automatically
        donorRepository.save(donor); // Save to MySQL!
        return "redirect:/"; // Reload the home page
    }
}