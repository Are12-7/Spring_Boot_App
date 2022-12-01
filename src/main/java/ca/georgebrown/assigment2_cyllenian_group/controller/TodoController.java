/*
Project: < Web Application - Cyllenian Group >
Assignment: < Assignment 2 >
Author(s): < Author name: Carlos Arellano - Renzzi Adorador - Ronak Gala >
Student Number: <101339585 - 101277841 - 101300174 >
Date: 30/11/2022
Description: This controller allows us to define the routes of the meals in our application.
Users can plan their meals in advance. The name and routes of this controller have in some cases been
referred to as "to-do" since scheduling something is a "to do" activity. Users must fill out the form
only with the name of the recipe and description, since the date of creation and modification will be generated automatically.
Users can update their meal plan and mark it as "completed"
Routes have been defined for get all meals planned (/planmeal),create plan meal (/newmeal),
save plan meal (/savetodo), edit plan meal (edit/to-do-list/{tid}), and delete plan meal (/delete/to-do-list/{tid})
 */

package ca.georgebrown.assigment2_cyllenian_group.controller;


import ca.georgebrown.assigment2_cyllenian_group.model.Todo;
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

@EnableJpaAuditing
@Controller
public class TodoController {

    @Autowired
    TodoServices todoServices;


    //GET ALL
    @RequestMapping("/planmeal")
    public String viewTodoPage(Model model) {
        List<Todo> listTodo = todoServices.listAll();
        model.addAttribute("listTodo", listTodo);
        return "todo";
    }

    //CREATE MEAL
    @RequestMapping("/newmeal")
    public String newTodoPage(Model model) {
        Todo todo = new Todo();
        model.addAttribute(todo);
        return "new_todo";
    }

    //SAVE MEAL
    @RequestMapping(value = "/savetodo", method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("todo") Todo todo) {
        todoServices.save(todo);
        return "redirect:/planmeal";
    }

    //EDIT MEAL
    @RequestMapping("edit/todo-list/{tid}")
    public ModelAndView showEditTodoPage(@PathVariable(name = "tid") Long tid) {
        ModelAndView mav = new ModelAndView("edit_todo");
        Todo todo = todoServices.get(tid);
        mav.addObject("todo", todo);
        return mav;
    }

    //DELETE MEAL
    @RequestMapping("delete/todo-list/{tid}")
    public String deleteTodoPage(@PathVariable(name = "tid") Long tid) {
        todoServices.delete(tid);
        return "redirect:/planmeal";
    }

}
