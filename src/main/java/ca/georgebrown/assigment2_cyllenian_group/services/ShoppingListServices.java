/*
Project: < Web Application - Cyllenian Group >
Assignment: < Assignment 2 >
Author(s): < Author name: Carlos Arellano - Renzzi Adorador - Ronak Gala >
Student Number: <101339585 - 101277841 - 101300174 >
Date: 30/11/2022
Description: This services file was created to define the methods for creating, updating, reading,
and deleting shopping list (findAll - save - findById - deleteById - findByKeyword).
We decided to create a specific file for the different methods so that
we don't have all the information in one file (controller).
*/

package ca.georgebrown.assigment2_cyllenian_group.services;

import ca.georgebrown.assigment2_cyllenian_group.model.ShoppingList;
import ca.georgebrown.assigment2_cyllenian_group.repository.ShopphingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListServices {
    @Autowired
    private ShopphingListRepository shoppingListRepo;

    //GET ALL
    public List<ShoppingList> listAll(){
        return shoppingListRepo.findAll();
    }

    //SAVE List
    public void save(ShoppingList shoppingList) {
        shoppingListRepo.save(shoppingList);
    }

    //GET List
    public ShoppingList get(Long id){
        return shoppingListRepo.findById(id).get();
    }

    //DELETE List
    public void delete(Long id){
        shoppingListRepo.deleteById(id);
    }

    //ADD TO CART BY KEYWORD (ADD CART = TRUE)
    public List<ShoppingList> findByKeyword(String keyword){
        return shoppingListRepo.findByKeyword(keyword);
    }
}
