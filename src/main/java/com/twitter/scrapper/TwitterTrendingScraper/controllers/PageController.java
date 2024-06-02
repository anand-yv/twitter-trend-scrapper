package com.twitter.scrapper.TwitterTrendingScraper.controllers;

import com.twitter.scrapper.TwitterTrendingScraper.dtos.TrendResponseDto;
import com.twitter.scrapper.TwitterTrendingScraper.services.TwitterTrendServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PageController {
    @Autowired
    private TwitterTrendServices twitterTrendServices;

    @GetMapping("/start")
    public TrendResponseDto startTheApp() throws InterruptedException {
        return twitterTrendServices.actionPerform();
    }
}
