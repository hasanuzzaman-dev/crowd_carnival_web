package com.hasan.crowdcarnival.controller;

import com.hasan.crowdcarnival.helper.MyMessage;
import com.hasan.crowdcarnival.models.Address;
import com.hasan.crowdcarnival.models.Role;
import com.hasan.crowdcarnival.models.User;
import com.hasan.crowdcarnival.models.UserImage;
import com.hasan.crowdcarnival.repositories.RoleRepository;
import com.hasan.crowdcarnival.repositories.UserRepository;
import com.hasan.crowdcarnival.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SignUpController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

/*    // Handler for registering user
    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                               @RequestParam(value = "agreement", defaultValue = "false") Boolean agreement,
                               Model model,
                               HttpSession session) {

        try {

            if (!agreement) {
                System.out.println("You have not agreed the terms & conditions");
                throw new Exception("You have not agreed the terms & conditions");
            }
            if (bindingResult.hasErrors()){
                model.addAttribute("user", user);
                return "signUp";
            }
            user.setRole("ROLE_USER");
            user.setEnabled(true);
            user.setImageUrl("default.png");
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            System.out.println("USER: " + user.toString());
            System.out.println("AGREEMENT: " + agreement);

            User savedUser = this.userRepository.save(user);

            // Show empty user in frontend
            model.addAttribute("user", new User());

            session.setAttribute("message",new MyMessage("Successfully Registered!! ", "alert-success"));

            return "signUp";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute(
                    "message",
                    new MyMessage("Something went wrong !! " + e.getMessage(), "alert-danger")
            );
            return "signUp";
        }


    }

    */

    // Handler for registering user
    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                               @RequestParam(value = "agreement", defaultValue = "false") Boolean agreement,
                               Model model, @RequestParam("processImage") MultipartFile[] multipartFiles,
                               HttpSession session) {

        try {

            if (!agreement) {
                System.out.println("You have not agreed the terms & conditions");
                throw new Exception("You have not agreed the terms & conditions");
            }
            if (bindingResult.hasErrors()){
                model.addAttribute("user", user);
                return "signUp";
            }

            if (multipartFiles.length < 1){
                model.addAttribute("contact", user);
                session.setAttribute("message", new MyMessage("Please Select a Photo", "alert-danger"));
                return "signUp";
            }
            UserImage userImage = new UserImage();
            int i = 1;
            for (MultipartFile multipartFile: multipartFiles){

               if (i == 1){
                   userImage.setUserPhotoUrl(multipartFile.getOriginalFilename());
               }else if (i==2){
                   userImage.setUserNidFrontUrl(multipartFile.getOriginalFilename());
               }else if (i== 3){
                   userImage.setUserNidBackUrl(multipartFile.getOriginalFilename());
               }
                File saveFile = new ClassPathResource("static/img").getFile();

                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + multipartFile.getOriginalFilename());
                Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File is Uploaded");

               i++;

            }

           List<Address> addressList = user.getAddress();
            System.out.println("Size: "+addressList.size());
            for (Address address: addressList){
                address.setUser(user);
            }

           // Role role = new Role("INIT");

            Role role = roleService.findById(3);

            userImage.setUser(user);
            user.getRoles().add(role);

            user.setEnabled(true);
            user.setImageUrl("default.png");
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setUserImage(userImage);
            System.out.println("USER: " + user.toString());
            System.out.println("AGREEMENT: " + agreement);
           // role.getUsers().add(user);

            User savedUser = this.userRepository.save(user);

            // Show empty user in frontend
            model.addAttribute("user", new User());

            session.setAttribute("message",new MyMessage("Successfully Registration. Please LogIn !! ", "alert-success"));

            return "redirect:/signIn";
        }catch (Exception e) {
            e.printStackTrace();
            user.setPassword("");
            model.addAttribute("user", user);
            session.setAttribute("message", new MyMessage("Something went wrong !! \n" + e.getLocalizedMessage(), "alert-danger"));
            return "signUp";
        }


    }


}
