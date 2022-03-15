package com.hasan.crowdcarnival.controller;

import com.hasan.crowdcarnival.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

/*    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    @ResponseBody
    private String test(){

        User user  = new User();
        user.setName("Hasan");
        user.setEmail("hasan@gmail.com");
        Contact contact = new Contact();
        user.getContacts().add(contact);
        userRepository.save(user);

        return "Working";
    }*/

    @RequestMapping("/")
    private String home(Model model){
        model.addAttribute("title", "Home - Crowd Carnival");
        return "home";
    }

    @RequestMapping("/about")
    private String about(Model model){
        model.addAttribute("title", "About - Crowd Carnival");
        return "about";
    }

    @RequestMapping("/signUp")
    private String signUp(Model model){
        model.addAttribute("title", "SignUp - Crowd Carnival");
        model.addAttribute("user", new User());
        return "signUp";
    }

    // handler for custom login
    @GetMapping("/signIn")
    public String customLogin(Model model){
        model.addAttribute("title","Login - Crowd Carnival");
        return "login";
    }





}
