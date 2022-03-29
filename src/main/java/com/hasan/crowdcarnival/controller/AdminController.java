package com.hasan.crowdcarnival.controller;

import com.hasan.crowdcarnival.helper.MyMessage;
import com.hasan.crowdcarnival.models.Contact;
import com.hasan.crowdcarnival.models.Project;
import com.hasan.crowdcarnival.models.User;
import com.hasan.crowdcarnival.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Collections;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    // Open add Project form handler
    @GetMapping("/add-project")
    public String openAddContactForm(Model model) {
        model.addAttribute("title", "Add Project");
        model.addAttribute("project", new Project());
        return "verified/add_project_form";
    }

    // save project handler
    @PostMapping("/save-project")
    public String saveProject(@Valid @ModelAttribute Project project, BindingResult bindingResult,
                              @RequestParam("projectFile") MultipartFile multipartFile,
                              Model model, Principal principal, HttpSession session){

        try {
            if (bindingResult.hasErrors()){
                System.out.println("Errors"+bindingResult.hasErrors());
                model.addAttribute("project", project);
                return "verified/add_project_form";
            }

            String userName = principal.getName();
            User user = this.userService.getUserByUsername(userName);

            if (multipartFile.isEmpty()) {
                //
                System.out.println("multipartFile.isEmpty()");
                System.out.println("File not Uploaded");
                model.addAttribute("project", project);
                session.setAttribute("message", new MyMessage("Please Select a File", "alert-danger"));
                return "verified/add_contact_form";

            } else {
                project.setProjectFile(multipartFile.getOriginalFilename());

                System.out.println("multipartFile.isNotEmpty()");
                // File save to any folder
                /*String userDirectory = System.getProperty("user.dir");
                String uploadDirectory = userDirectory + "\\uploadImg";
                */
                // image save to static folder
                File saveFile = new ClassPathResource("static/img").getFile();

                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + multipartFile.getOriginalFilename());
                Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File is Uploaded");
            }

            project.setProjectCreateDate(new Timestamp(System.currentTimeMillis()));
            project.setUsers(Collections.singleton(user));

            user.getProjects().add(project);
            this.userService.save(user);
            System.out.println("Data: " + project);
            model.addAttribute("project", new Project());

            /*Message Success*/
            session.setAttribute("message", new MyMessage("Project added Successfully!! ", "alert-success"));

            return "verified/add_project_form";




        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("project", project);
            /* Message danger */
            session.setAttribute("message", new MyMessage("Something went wrong " + e.getMessage(), "alert-danger"));
        }

        return "verified/add_project_form";
    }



}
