package ca.georgebrown.assigment2_cyllenian_group.services;

import ca.georgebrown.assigment2_cyllenian_group.model.Recipe;
import ca.georgebrown.assigment2_cyllenian_group.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    public Recipe update(Recipe recipe){
        Optional<Recipe> updateRcp = repo.findById(recipe.getRid());
        Recipe exists = updateRcp.get();
        exists.setRname(recipe.getRname());
        exists.setRdescription(recipe.getRdescription());
        exists.setRcountry(recipe.getRcountry());
        exists.setSteps(recipe.getSteps());
        exists.setFavourite(recipe.isFavourite());
        return repo.save(exists);
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
