package com.twitter.scrapper.TwitterTrendingScraper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.scrapper.TwitterTrendingScraper.models.TrendModel;
import com.twitter.scrapper.TwitterTrendingScraper.repositories.TrendRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RestController
public class TrendsController {

    @Autowired
    private TrendRepository trendsRepository;

    @GetMapping("/all-trends")
    public List<TrendModel> getAllTrends(){
        return trendsRepository.findAll();
    }

    @GetMapping("/trendsById")
    public Optional<TrendModel> getTrendsById(@RequestParam String id) {
        return trendsRepository.findById(id);
    }
    

}
