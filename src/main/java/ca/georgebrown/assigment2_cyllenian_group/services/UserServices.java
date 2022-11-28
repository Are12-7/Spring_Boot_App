package ca.georgebrown.assigment2_cyllenian_group.services;

import ca.georgebrown.assigment2_cyllenian_group.model.Todo;
import ca.georgebrown.assigment2_cyllenian_group.model.User;
import ca.georgebrown.assigment2_cyllenian_group.repository.TodoRepository;
import ca.georgebrown.assigment2_cyllenian_group.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepo;

    public List<User> listAll(){
        return userRepo.findAll();
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public User get(Long id){
        return userRepo.findById(id).get();
    }

    public void delete(Long id){userRepo.deleteById(id);
    }
}
