package com.system.appointment2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/login")
    public String loginForm()
    {
        return "login";
    }

}
