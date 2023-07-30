package com.mycompany.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.app.entities.MyUser;

@Controller
public class SignupController {
    
    @Autowired UserRepository userRepository;

    @PostMapping("/newUser")
    public String addNewUser(@ModelAttribute("user")MyUser user){
        
        if (userRepository.exists(Example.of(user))){
            System.out.println("User Already Exists");
        }
        userRepository.save(user);
        return "index.html";
    }
    
}
