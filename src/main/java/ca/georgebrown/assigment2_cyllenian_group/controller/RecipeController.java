/*
Project: < Web Application - Cyllenian Group >
Assignment: < Assignment 2 >
Author(s): < Author name: Carlos Arellano - Renzzi Adorador - Ronak Gala >
Student Number: <101339585 - 101277841 - 101300174 >
Date: 30/11/2022
Description: This controller allows us to define the routes of the recipes in our application.
Routes have been defined for get all recipes (/recipes), get my favorite recipes (/my-favourite),
create recipe (/newrecipe), save recipe (/saverecipe), edit recipe (/edit/{rid}), delete recipe (/delete/{rid}),
and view steps (steps/{rid})
 */

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
    //SEARCH OPTION KEYWORD
    @RequestMapping("/recipes")
    public String viewHomePage(Model model, String keywrd) {
        //IF USER TYPE IN SEARCH BAR
        //DISPLAY RECIPES BASED ON USER INPUT
        if (keywrd != null) {
            List<Recipe> listRecipe = service.searchRecipeBy(keywrd);
            model.addAttribute("listRecipe", listRecipe);

        }
        //DISPLAY ALL RECIPES
        else {
            List<Recipe> listRecipe = service.listAll();
            model.addAttribute("listRecipe", listRecipe);
        }


        return "recipe";
    }

    //GET MY FAVOURITE RECIPES
    @RequestMapping("/my-favourite")
    public String viewFavouritePage(Model model, String keyword) {
        List<Recipe> listRecipe = service.findByKeyword(keyword);
        model.addAttribute("listRecipe", listRecipe);
        return "my_favourite";
    }


    //CREATE RECIPE
    @RequestMapping("/newrecipe")
    public String newRecipePage(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute(recipe);
        return "new_recipe";
    }

    //SAVE RECIPE
    @RequestMapping(value = "/saverecipe", method = RequestMethod.POST)
    public String saveRecipe(@ModelAttribute("recipe") Recipe recipe) {
        service.save(recipe);
        return "redirect:/recipes";
    }

    //EDIT RECIPE
    @RequestMapping("edit/{rid}")
    public ModelAndView showEditRecipePage(@PathVariable(name = "rid") Long rid) {
        ModelAndView mav = new ModelAndView("edit_recipe");
        Recipe recipe = service.get(rid);
        mav.addObject("recipe", recipe);
        return mav;
    }

    //DELETE RECIPE
    @RequestMapping("delete/{rid}")
    public String deleteRecipePage(@PathVariable(name = "rid") Long rid) {
        service.delete(rid);
        return "redirect:/recipes";
    }

    //VIEW STEPS
    @RequestMapping("steps/{rid}")
    public ModelAndView viewStepsPage(@PathVariable(name = "rid") Long rid) {
        ModelAndView mav = new ModelAndView("view_steps");
        Recipe recipe = service.get(rid);
        mav.addObject("recipe", recipe);
        return mav;
    }

    @RequestMapping("ingredient/{rid}")
    public ModelAndView viewIngredientPage(@PathVariable(name = "rid") Long rid) {
        ModelAndView mav = new ModelAndView("view_ingredients");
        Recipe recipe = service.get(rid);
        mav.addObject("recipe", recipe);
        return mav;
    }


}
