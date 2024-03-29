package com.example.carturestibackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView homePage() {

       ModelAndView modelAndView= new ModelAndView();
       modelAndView.setViewName("home");

        return modelAndView;

    }
}
