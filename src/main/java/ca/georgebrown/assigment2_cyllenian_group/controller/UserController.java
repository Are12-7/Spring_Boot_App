/*
Project: < Web Application - Cyllenian Group >
Assignment: < Assignment 2 >
Author(s): < Author name: Carlos Arellano - Renzzi Adorador - Ronak Gala >
Student Number: <101339585 - 101277841 - 101300174 >
Date: 30/11/2022
Description: This controller allows us to define the routes of users in our application including login and register.
Routes have been defined for get all user (/user), create new user (/register), login(/login), save user (/saveuser), edit
user (/edit/user/{uid}), and delete user (/delete/user/{uid})
*/

package ca.georgebrown.assigment2_cyllenian_group.controller;

import ca.georgebrown.assigment2_cyllenian_group.model.User;
import ca.georgebrown.assigment2_cyllenian_group.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServices userServices;


    //GET USER
    @RequestMapping("/user")
    public String viewHomePage(Model model) {
        List<User> listUser = userServices.listAll();
        model.addAttribute("listUser", listUser);
        return "profile";
    }

    //REGISTER
    @RequestMapping("/register")
    public String registerPage(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "register";
    }

    //SAVE NEW USER
    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userServices.save(user);
        return "redirect:/login";
    }

    //LOGIN
    @RequestMapping("/login")
    public String loginPage(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "login";
    }


    //SAVE UPDATED USER
    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String saveUpdatedUser(@ModelAttribute("user") User user) {
        userServices.save(user);
        return "redirect:/user";
    }

    //EDIT USER
    @RequestMapping("edit/user/{uid}")
    public ModelAndView showEditUserPage(@PathVariable(name = "uid") Long uid) {
        ModelAndView mav = new ModelAndView("edit_profile");
        User user = userServices.get(uid);
        mav.addObject("user", user);
        return mav;
    }


    //DELETE USER
    //NOT REQUIRED BUT USED FOR TESTING PURPOSES
    @RequestMapping("delete/user/{uid}")
    public String deleteUser(@PathVariable(name = "uid") Long uid) {
        userServices.delete(uid);
        return "redirect:/profile";
    }

}
