package com.ajcordenete.springboot.demomvcsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showDemo() {

        return "home";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "plain-login";
    }
}
