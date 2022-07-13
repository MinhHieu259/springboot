package com.minnhieu.springboot.controller;

import com.minnhieu.springboot.model.Address;
import com.minnhieu.springboot.model.User;
import com.minnhieu.springboot.service.AddressService;
import com.minnhieu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;

    @GetMapping("/form")
    public String addressForm(Model model){
        model.addAttribute("addressForm", new Address());
        model.addAttribute("users", userService.userList());
        return "address/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable("id") Long id, Model model){
        model.addAttribute("message", addressService.deleteAddress(id));
        return "message";
    }

    @PostMapping("/add")
    public String addAddress(@ModelAttribute Address address, Model model){
        String message = "";
        if(address.getId() == null){
            message = " added";
        } else {
            message = " updated";
        }
        model.addAttribute("message", addressService.addAddress(address).getUser().getUserName()+message+" address successfully");
        return "message";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("addressForm", addressService.findOne(id));
        model.addAttribute("users",  userService.userList());
        return "address/form";
    }
    @GetMapping("/list/{id}")
    public Address findOne(@PathVariable("id") Long id){
        return addressService.findOne(id);
    }

    @GetMapping("/list")
    public String addressList(Model model){
        model.addAttribute("addresses", addressService.addressList());
        return "address/list";
    }
}
