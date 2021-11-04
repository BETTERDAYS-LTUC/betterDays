package com.example.betterDays.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class hello {
    @RequestMapping({"/hello"})
    @ResponseBody
    public String hello() {
        System.out.println("hello world");
        return "Hello World";
    }
    @GetMapping("/")
    public String getHello(){
        return "index";
    }
}
