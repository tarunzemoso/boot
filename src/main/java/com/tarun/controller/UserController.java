package com.tarun.controller;

import com.tarun.entity.User;
import com.tarun.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class UserController {
    private UserService userSerivce;

    public UserController(UserService theCourseService) {
        userSerivce = theCourseService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listCourses(Model theModel) {

        // get employees from db
        List<User> theUsers = userSerivce.findAll();

        // add to the spring model
        theModel.addAttribute("users", theUsers);

        return "list-Users";
    }

    @GetMapping("/FormForAdd")
    public String FormForAdd(Model theModel) {

        // create model attribute to bind form data
        User theUser = new User();

        theModel.addAttribute("users", theUser);

        return "user-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userName") String theUserName,
                                    Model theModel) {

        // get the employee from the service
        User theUser = userSerivce.findByUserName(theUserName);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("users", theUser);

        // send over to our form
        return "user-form";
    }


    @PostMapping("/save")
    public String saveBook(
            @ModelAttribute("user") @Valid User theUser, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user-form";
        }
        else {
            // save the employee
            userSerivce.save(theUser);

            // use a redirect to prevent duplicate submissions
            return "redirect:/students/list";
        }
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("userName") String theUserName) {

        // delete the employee
        userSerivce.deleteByUserName(theUserName);

        // redirect to /employees/list
        return "redirect:/students/list";

    }

}
