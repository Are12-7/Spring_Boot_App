package ca.georgebrown.assigment2_cyllenian_group.services;

import ca.georgebrown.assigment2_cyllenian_group.model.Todo;
import ca.georgebrown.assigment2_cyllenian_group.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServices {

    @Autowired
    private TodoRepository todoRepo;

    public List<Todo> listAll(){
        return todoRepo.findAll();
    }

    public void save(Todo todo) {
        todoRepo.save(todo);
    }

    public Todo get(Long id){
        return todoRepo.findById(id).get();
    }

    public void delete(Long id){
        todoRepo.deleteById(id);
    }
}
