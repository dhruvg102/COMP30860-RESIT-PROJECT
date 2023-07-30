package com.mycompany.app.entities;

import java.util.ArrayList;
import java.util.List;


public class LoggedInUser  {
    
    private static MyUser user;

    public static void setLoggedInUser( String username, String email, String password){
        LoggedInUser.user.setUsername(username); 
        LoggedInUser.user.setEmail(email);
        LoggedInUser.user.setPassword(password);
    }

    public static void setLoggedInUser(MyUser user){
        LoggedInUser.user = user;
    }
  
    public static MyUser getUser(){return user;}
    public static String getUsername() { return LoggedInUser.user.getUsername(); }
    public static void setUsername(String username) { LoggedInUser.user.setUsername(username); }
    public static String getPassword() { return LoggedInUser.user.getPassword(); }
    public static void setPassword(String password) { LoggedInUser.user.setPassword(password);  }
    public static String getEmail() { return LoggedInUser.user.getEmail(); }
    public static void setEmail(String email) { LoggedInUser.user.setEmail(email); }
    public static void setOrderHistory(ArrayList<MyOrder> orderHistory) {LoggedInUser.user.setOrderHistory(orderHistory);}
    public static List<MyOrder> getOrderHistory() {return LoggedInUser.user.getOrderHistory();}
}
