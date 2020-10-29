package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn2",method = RequestMethod.POST)
//    与name属性一致
    public String login(String username,String password){
        UserBean userBean = userService.loginIn(username,password);
        if(userBean!=null){
            return "success";
        }else {
            return "error";
        }
    }

    @PostMapping("/loginIn")
    public String login1(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session ) {
        UserBean userBean = userService.loginIn(username, password);
        if (userBean != null) {
            session.setAttribute("loginUser",username);
            return "redirect:main.html";

        }else {
            model.addAttribute("msg","用户名密码错误");
            return "index";
        }
    }



}
