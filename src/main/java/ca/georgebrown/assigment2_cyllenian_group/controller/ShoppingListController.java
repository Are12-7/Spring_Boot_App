/*
Project: < Web Application - Cyllenian Group >
Assignment: < Assignment 2 >
Author(s): < Author name: Carlos Arellano - Renzzi Adorador - Ronak Gala >
Student Number: <101339585 - 101277841 - 101300174 >
Date: 30/11/2022
Description: This controller allows us to define the routes of our shopping list in our application.
The users can create a new item to their shopping list by filling out the form with the name of the recipe,
the ingredient they want to add to their list, and the quantity. In addition, the user will have the option
to update their list and mark the products on their list as "purchased". Finally, the users can add their
shopping list to the shopping cart.
Routes have been defined for get all shopping list (/shoppinglist),create item (/newitem),
save event (/savelist), edit plan (edit/shoppinglist/{lid}), delete event (delete/shoppinglist/{lid})
shopping cart (shoppingCart)
*/

package ca.georgebrown.assigment2_cyllenian_group.controller;

import ca.georgebrown.assigment2_cyllenian_group.model.Recipe;
import ca.georgebrown.assigment2_cyllenian_group.model.ShoppingList;
import ca.georgebrown.assigment2_cyllenian_group.services.RecipeServices;
import ca.georgebrown.assigment2_cyllenian_group.services.ShoppingListServices;
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
public class ShoppingListController {
    @Autowired
    ShoppingListServices shoppingServices;


    //GET ALL LIST
    @RequestMapping("/shoppinglist")
    public String viewShoppingPage(Model model){
        List<ShoppingList> listShopping = shoppingServices.listAll();
        model.addAttribute("listShoping",listShopping);
        return "list";
    }


    //CREATE List
    @RequestMapping("/newitem")
    public String newListPage(Model model){
        ShoppingList shoppingList = new ShoppingList();
        model.addAttribute(shoppingList);
        return "new_list";
    }

    //SAVE List
    @RequestMapping(value = "/savelist", method = RequestMethod.POST)
    public String saveList(@ModelAttribute("shoppingList") ShoppingList shoppingList){
        shoppingServices.save(shoppingList);
        return "redirect:/shoppinglist";
    }

    //EDIT List
    @RequestMapping("edit/shoppinglist/{lid}")
    public ModelAndView showShoppingListPage(@PathVariable(name="lid") Long lid){
        ModelAndView mav= new ModelAndView("edit_list");
        ShoppingList shoppingList = shoppingServices.get(lid);
        mav.addObject("shoppingList",shoppingList);
        return mav;
    }

    //DELETE List
    @RequestMapping("delete/shoppinglist/{lid}")
    public String deleteListPage(@PathVariable (name="lid") Long lid) {
        shoppingServices.delete(lid);
        return "redirect:/shoppinglist";
    }

    //SHOPPING CART
    @RequestMapping("/shoppingCart")
    public String viewShoppingCartPage(Model model, String keyword){
        List<ShoppingList> listShopping = shoppingServices.findByKeyword(keyword);
        model.addAttribute("listShopping",listShopping);
        return "my_shopping_cart";
    }


}
