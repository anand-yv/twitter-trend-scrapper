package com.twitter.scrapper.TwitterTrendingScraper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TwitterTrendController {

    @GetMapping("/")
    public String homePage(Model model) {
//        model.addAttribute("message", "Welcome to our website!");
        return "index"; // Thymeleaf template name (greeting.html)
    }


}
