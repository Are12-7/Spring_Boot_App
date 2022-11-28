package ca.georgebrown.assigment2_cyllenian_group.repository;

import ca.georgebrown.assigment2_cyllenian_group.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
