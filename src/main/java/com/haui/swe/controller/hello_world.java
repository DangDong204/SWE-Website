package com.haui.swe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hello_world {

    @GetMapping("/hello")
    public String hello(){
        return "hello_world";
    }
}
