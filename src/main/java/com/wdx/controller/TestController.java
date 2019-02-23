package com.wdx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("testThymeleaf")
    public String testThymeleaf(Model model){
        model.addAttribute("name","结城明日奈");
        return "test222";

    }
}
