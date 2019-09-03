package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value="")
public class IndexController {
    @RequestMapping(value="")
    public String index(Model model)
    {
        model.addAttribute("title","Home Page");
        return "base/index";
    }
}
