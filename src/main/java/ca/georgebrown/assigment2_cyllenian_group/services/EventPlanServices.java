package ca.georgebrown.assigment2_cyllenian_group.services;

import ca.georgebrown.assigment2_cyllenian_group.model.EventPlan;
import ca.georgebrown.assigment2_cyllenian_group.model.Todo;
import ca.georgebrown.assigment2_cyllenian_group.repository.EventPlanRepository;
import ca.georgebrown.assigment2_cyllenian_group.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventPlanServices {
    @Autowired
    private EventPlanRepository eventRepo;

    public List<EventPlan> listAll(){
        return eventRepo.findAll();
    }

    public void save(EventPlan event) {
        eventRepo.save(event);
    }

    public EventPlan get(Long id){
        return eventRepo.findById(id).get();
    }

    public void delete(Long id){
        eventRepo.deleteById(id);
    }
}
