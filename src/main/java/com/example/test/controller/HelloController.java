package com.example.test.controller;


import com.sun.org.apache.xpath.internal.objects.XObject;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String sayHello()
    {



//        model.addAttribute("msg","hello");
        return "index";
    }
}
