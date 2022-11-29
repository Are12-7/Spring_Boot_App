package ca.georgebrown.assigment2_cyllenian_group.services;

import ca.georgebrown.assigment2_cyllenian_group.model.Recipe;
import ca.georgebrown.assigment2_cyllenian_group.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServices {

    @Autowired
    private RecipeRepository repo;

    //GET ALL RECIPES
    public List<Recipe> listAll(){
        return repo.findAll();
    }

    //SAVE RECIPES
    public void save(Recipe recipe) {
        repo.save(recipe);
    }

    //GET RECIPE BY ID
    public Recipe get(Long id){
        return repo.findById(id).get();
    }

    //DELETE RECIPE
    public void delete(Long id){
        repo.deleteById(id);
    }

    //GET RECIPE BY KEYWORD (FAVOURITE RECIPE = TRUE)
    public List<Recipe> findByKeyword(String keyword){
        return repo.findByKeyword(keyword);
    }

    //SEARCH OPTION
    public List<Recipe> searchRecipeBy(String keywrd){
        return repo.searchRecipeBy(keywrd);
    }


}
