package ca.georgebrown.assigment2_cyllenian_group.repository;

import ca.georgebrown.assigment2_cyllenian_group.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopphingListRepository extends JpaRepository<ShoppingList, Long> {

    @Query(value = "select * from ShoppingList s where s.cart=true ",nativeQuery = true)
    List<ShoppingList> findByKeyword(@Param("keyword") String keyword);
}
