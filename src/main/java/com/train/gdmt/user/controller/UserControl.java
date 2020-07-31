package com.train.gdmt.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("login")
public class UserControl {
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }
}
