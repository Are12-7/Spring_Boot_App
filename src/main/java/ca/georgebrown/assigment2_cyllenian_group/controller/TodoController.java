package ca.georgebrown.assigment2_cyllenian_group.controller;

import ca.georgebrown.assigment2_cyllenian_group.model.Recipe;
import ca.georgebrown.assigment2_cyllenian_group.model.Todo;
import ca.georgebrown.assigment2_cyllenian_group.services.RecipeServices;
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
    public String viewTodoPage(Model model){
        List<Todo> listTodo = todoServices.listAll();
        model.addAttribute("listTodo",listTodo);
        return "todo";
    }

    //CREATE RECIPE
    @RequestMapping("/newtodo")
    public String newTodoPage(Model model){
        Todo todo = new Todo();
        model.addAttribute(todo);
        return "new_todo";
    }

    //SAVE RECIPE
    @RequestMapping(value = "/savetodo", method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("todo") Todo todo){
        todoServices.save(todo);
        return "redirect:/planmeal";
    }

    //EDIT RECIPE
    @RequestMapping("edit/todo-list/{tid}")
    public ModelAndView showEditTodoPage(@PathVariable(name="tid") Long tid){
        ModelAndView mav= new ModelAndView("edit_todo");
        Todo todo = todoServices.get(tid);
        mav.addObject("todo",todo);
        return mav;
    }

    //DELETE RECIPE
    @RequestMapping("delete/todo-list/{tid}")
    public String deleteTodoPage(@PathVariable (name="tid") Long tid) {
        todoServices.delete(tid);
        return "redirect:/planmeal";
    }

}
