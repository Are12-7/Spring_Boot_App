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
    @RequestMapping("/newlist")
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

}
