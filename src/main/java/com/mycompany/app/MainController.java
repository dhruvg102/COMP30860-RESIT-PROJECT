package com.mycompany.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mycompany.app.entities.MyUser;

@Controller
public class MainController {

    

    @GetMapping("/loginpage")
    public String login(Model model) {
        MyUser user = new MyUser();
        model.addAttribute("user", user);
        return "login.html";
    }

   

   

}
