package com.lmj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HelloController {
    @GetMapping("/test/{a}")
    public String Test1(@PathVariable String a, Model model){
        model.addAttribute("msg",a);
        return "Test";
    }
}
