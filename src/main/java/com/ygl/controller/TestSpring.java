package com.ygl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestSpring {
    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "index";
    }
}
