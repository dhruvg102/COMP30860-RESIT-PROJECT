package com.mycompany.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mycompany.app.entities.LoggedInUser;
import com.mycompany.app.entities.MyUser;

@Controller
public class AuthenticationController {

    @Autowired UserRepository userRepository;

    @GetMapping("/login")
    public String login(@ModelAttribute("user")MyUser user, Model model){

        if (userRepository.exists(Example.of(user))){{
                    System.out.println("SUCCESS");
                    LoggedInUser.setLoggedInUser(user);
                    return "index.html";
                }
            }
            System.out.println("FAIL");
            return "login.html";

        }

        
    // private void printDB(){
    //     for(int i = 0; i<40;i++){System.out.print("-");}
    //     System.out.println("");
    //     for(int i = 0 ; i < userRepository.findAll().size(); i++){
    //         MyUser x = userRepository.findAll().get(i);
    //         System.out.print("| ");
    //         System.out.print(x.getId() + "\t| " +x.getUsername() + "\t| " + x.getEmail() + "\t| " + x.getPassword());
    //         System.out.println("\t|");
    //     }
    //     System.out.println("");
    //     for(int i = 0; i<40;i++){System.out.print("-");}

    // }
    // private void printUser(MyUser x){
    //     System.out.println("\n");
    //     System.out.println(x.getId() + " " +x.getUsername() + " " + x.getEmail() + " " + x.getPassword());
    // }
}
