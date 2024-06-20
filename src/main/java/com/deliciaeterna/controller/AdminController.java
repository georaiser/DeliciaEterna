package com.deliciaeterna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class AdminController {
 
    @GetMapping    
    public String home(Model model) {
        return "home/home"; 
    }
}