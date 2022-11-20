package ca.georgebrown.assigment2_cyllenian_group.services;

import ca.georgebrown.assigment2_cyllenian_group.model.Recipe;
import ca.georgebrown.assigment2_cyllenian_group.model.ShoppingList;
import ca.georgebrown.assigment2_cyllenian_group.repository.RecipeRepository;
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
}
