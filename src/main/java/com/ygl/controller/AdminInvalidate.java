package com.ygl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminInvalidate{

    @RequestMapping("invalidate")
    public String invalidate(HttpSession session){
        session.invalidate();
        return "login";
    }
}
