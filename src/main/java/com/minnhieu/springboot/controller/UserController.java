package com.minnhieu.springboot.controller;

import com.minnhieu.springboot.model.User;
import com.minnhieu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/form")
    public String userForm(Model model){
        model.addAttribute("userForm", new User());
        model.addAttribute("roles", userService.roleList());
        return "user/form";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("userForm", userService.findOne(id));
        model.addAttribute("roles", userService.roleList());
        return "user/form";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("message", userService.deleteUser(id));
        return "message";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user, Model model){
        String message = "";
        if(user.getId() == null){
            message = " added";
        } else {
            message = " updated";
        }
        model.addAttribute("message", userService.addUser(user).getUserName()+message+" successfully");
        return "message";
    }

    @RequestMapping("/list/{id}")
    public User findOne(@PathVariable("id") Long id){
        return userService.findOne(id);
    }

    @GetMapping("/list")
    public String userList(Model model){
        model.addAttribute("users", userService.userList());
        return "user/list";
    }
}
