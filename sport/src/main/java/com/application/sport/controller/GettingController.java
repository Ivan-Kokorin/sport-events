package com.application.sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GettingController {
    @GetMapping("/")
    public String greeting() {
        return "index";
    }

    @GetMapping("/main")
    public String api() {
        return "matches";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}