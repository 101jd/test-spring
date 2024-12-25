package org.example.demo.controller;

import org.example.demo.model.User;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = service.findAll();

        model.addAttribute("users", users);
        return "user-list";
    }


    // HOMEWORK
    @PostMapping("/user-create")
    public String create(User user){
        service.save(user);
        return "redirect:/users";
    }

    @PostMapping("user-delete/{u_id}")
    public String delete(int id){
        service.delete(id);
        return "redirect:/users";
    }

    @PostMapping("user-update/{fName}{lName}{u_id}")
    public String update(String fName, String lName, User user){
        service.update(fName, lName, user);
        return "redirect:/users";
    }


}
