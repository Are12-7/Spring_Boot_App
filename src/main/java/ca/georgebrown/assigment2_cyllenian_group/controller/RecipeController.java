package ca.georgebrown.assigment2_cyllenian_group.controller;

import ca.georgebrown.assigment2_cyllenian_group.model.Recipe;
import ca.georgebrown.assigment2_cyllenian_group.services.RecipeServices;
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
public class RecipeController {

    @Autowired
    RecipeServices service;


    //GET ALL RECIPES
    @RequestMapping("/recipes")
    public String viewHomePage(Model model){
            List<Recipe> listRecipe = service.listAll();
            model.addAttribute("listRecipe",listRecipe);
        return "recipe";
    }
    //GET MY FAVOURITE RECIPES
    @RequestMapping("/my-favourite")
    public String viewFavouritePage(Model model, String keyword){
            List<Recipe> listRecipe = service.findByKeyword(keyword);
            model.addAttribute("listRecipe",listRecipe);
        return "my_favourite";
    }


    //CREATE RECIPE
    @RequestMapping("/newrecipe")
    public String newRecipePage(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute(recipe);
        return "new_recipe";
    }

    //SAVE RECIPE
    @RequestMapping(value = "/saverecipe", method = RequestMethod.POST)
    public String saveRecipe(@ModelAttribute("recipe") Recipe recipe){
        service.save(recipe);
        return "redirect:/recipes";
    }

    //EDIT RECIPE
    @RequestMapping("edit/{rid}")
    public ModelAndView showEditRecipePage(@PathVariable (name="rid") Long rid){
        ModelAndView mav= new ModelAndView("edit_recipe");
        Recipe recipe = service.get(rid);
        mav.addObject("recipe",recipe);
        return mav;
    }

    //DELETE RECIPE
    @RequestMapping("delete/{rid}")
    public String deleteRecipePage(@PathVariable (name="rid") Long rid) {
        service.delete(rid);
        return "redirect:/recipes";
    }


}
