package com.hasan.crowdcarnival.controller;

import com.hasan.crowdcarnival.models.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // Open add form handler
    @GetMapping("/add-project")
    public String openAddContactForm(Model model) {
        model.addAttribute("title", "Add Project");
        model.addAttribute("contact", new Contact());
        return "verified/add_contact_form";
    }
}
