/*
Project: < Web Application - Cyllenian Group >
Assignment: < Assignment 2 >
Author(s): < Author name: Carlos Arellano - Renzzi Adorador - Ronak Gala >
Student Number: <101339585 - 101277841 - 101300174 >
Date: 30/11/2022
Description: This controller allows us to define the routes of the events in our application.
Routes have been defined for get all events (/eventplan),create event (/newevent),
save event (/save-event), edit plan (edit/eventplan/{eid}), and delete event (/delete/eventplan/{eid})
 */

package ca.georgebrown.assigment2_cyllenian_group.controller;

import ca.georgebrown.assigment2_cyllenian_group.model.EventPlan;
import ca.georgebrown.assigment2_cyllenian_group.model.Todo;
import ca.georgebrown.assigment2_cyllenian_group.services.EventPlanServices;
import ca.georgebrown.assigment2_cyllenian_group.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class EventPlanController {

    @Autowired
    EventPlanServices eventServices;


    //GET ALL
    @RequestMapping("/eventplan")
    public String viewTodoPage(Model model) {
        List<EventPlan> listEvent = eventServices.listAll();
        model.addAttribute("listEvent", listEvent);
        return "event_plan";
    }

    //CREATE EVENT
    @RequestMapping("/newevent")
    public String newEventPage(Model model) {
        EventPlan event = new EventPlan();
        model.addAttribute(event);
        return "new_event";
    }

    //SAVE EVENT
    @RequestMapping(value = "/save-event", method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("event") EventPlan event) {
        eventServices.save(event);
        return "redirect:/eventplan";
    }

    //EDIT EVENT
    @RequestMapping("edit/eventplan/{eid}")
    public ModelAndView showEditEventPage(@PathVariable(name = "eid") Long eid) {
        ModelAndView mav = new ModelAndView("edit_event");
        EventPlan event = eventServices.get(eid);
        mav.addObject("event", event);
        return mav;
    }

    //DELETE EVENT
    @RequestMapping("delete/eventplan/{eid}")
    public String deleteEventPage(@PathVariable(name = "eid") Long eid) {
        eventServices.delete(eid);
        return "redirect:/eventplan";
    }

}
