package ca.georgebrown.assigment2_cyllenian_group.repository;

import ca.georgebrown.assigment2_cyllenian_group.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {

    //FILTERING BY FAVOURITE = TRUE
    @Query(value = "select * from Recipe r where r.favourite = true",nativeQuery = true)
    List<Recipe> findByKeyword(@Param("keyword") String keyword);

    //SEARCH OPTION
    @Query(value = "select * from Recipe re where re.rname like %:keywrd% or re.rdescription like %:keywrd% or re.rcountry like %:keywrd% or re.rcountry like %:keywrd% or re.favourite like %:keywrd%",nativeQuery = true)
    List<Recipe> searchRecipeBy(@Param("keywrd") String keywrd);

}
