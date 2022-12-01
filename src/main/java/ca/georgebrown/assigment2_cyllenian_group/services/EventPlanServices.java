/*
Project: < Web Application - Cyllenian Group >
Assignment: < Assignment 2 >
Author(s): < Author name: Carlos Arellano - Renzzi Adorador - Ronak Gala >
Student Number: <101339585 - 101277841 - 101300174 >
Date: 30/11/2022
Description: This services file was created to define the methods for creating, updating, reading,
and deleting user events (findAll - save - findById - deleteById). We decided to create a specific file for the different methods so that
we don't have all the information in one file (controller).
*/

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

    public List<EventPlan> listAll() {
        return eventRepo.findAll();
    }

    public void save(EventPlan event) {
        eventRepo.save(event);
    }

    public EventPlan get(Long id) {
        return eventRepo.findById(id).get();
    }

    public void delete(Long id) {
        eventRepo.deleteById(id);
    }
}
