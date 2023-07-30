package com.mycompany.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.app.entities.LoggedInUser;
import com.mycompany.app.entities.MyOrder;
import com.mycompany.app.entities.MyProduct;
import com.mycompany.app.entities.MyUser;



@Controller
public class CartCheckoutController {
    
    @Autowired UserRepository userRepository;
    @Autowired OrderRepository orderRepository;
    @Autowired ProductRepository productRepository;

    HashMap<Float, MyProduct> cart = new HashMap<>();

    @RequestMapping("/addUntrained/{id}")
    public String cartUntrained(@PathVariable long id, Model model){
        Optional<MyProduct> prod = productRepository.findById(id);
    

        cart.put(prod.get().getUntrainedPrice(), prod.get());


        model.addAttribute("cart", cart.values());
       
        return "ShoppingCart.html";
    }
    @RequestMapping("/addTrained/{id}")
    public String cartTrained(@PathVariable Long id, Model model){

        Optional<MyProduct> prod = productRepository.findById(id);
        
        cart.put(prod.get().getTrainedPrice(), prod.get());

        model.addAttribute("cart", cart.values());
        
        return "ShoppingCart.html";

    }

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("cart", cart);
        return "ShoppingCart.html";
    }

    @GetMapping("/checkout")
    public  String payment(Model model){
        if(LoggedInUser.getUser() !=null)
            return "Checkout.html";
        else
        //TODO FIX index.html
            return "index.html";
    }


    @GetMapping("/orderPlaced")
    public String orderPlaced(){
        
        Optional<MyUser> user = userRepository.findOne(Example.of(LoggedInUser.getUser()));

        cart.forEach((key , value) -> {
            MyOrder order = new MyOrder(value.getId(), key, user.get());
            orderRepository.save(order);
        });
        

     return "index.html";
    }

}
