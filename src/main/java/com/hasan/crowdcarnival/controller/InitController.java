package com.hasan.crowdcarnival.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping( "/init")
public class InitController {

    @RequestMapping("/verification")
    public String verification(Model model, Principal principal) {
        model.addAttribute("title", "User Dashboard");
        return "init/verification";
    }
}
