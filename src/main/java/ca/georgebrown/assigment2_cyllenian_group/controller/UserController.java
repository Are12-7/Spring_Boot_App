package ca.georgebrown.assigment2_cyllenian_group.controller;


import ca.georgebrown.assigment2_cyllenian_group.model.Recipe;
import ca.georgebrown.assigment2_cyllenian_group.model.User;
import ca.georgebrown.assigment2_cyllenian_group.services.RecipeServices;
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
    public String viewHomePage(Model model){
        List<User> listUser = userServices.listAll();
        model.addAttribute("listUser",listUser);
        return "profile";
    }

    //CREATE USER
    @RequestMapping("/register")
    public String registerPage(Model model){
        User user = new User();
        model.addAttribute(user);
        return "register";
    }

    //SAVE USER
    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user){
        userServices.save(user);
        return "redirect:/login";
    }

    //EDIT USER
    @RequestMapping("edit/user/{uid}")
    public ModelAndView showEditUserPage(@PathVariable(name="uid") Long uid){
        ModelAndView mav= new ModelAndView("edit_profile");//EDIT USER
        User user = userServices.get(uid);
        mav.addObject("user",user);
        return mav;
    }

    //DELETE USER
    @RequestMapping("delete/user/{uid}")
    public String deleteUser(@PathVariable (name="uid") Long uid) {
        userServices.delete(uid);
        return "redirect:/profile";
    }

}
