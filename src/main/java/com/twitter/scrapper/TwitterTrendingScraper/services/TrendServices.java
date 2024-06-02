package com.twitter.scrapper.TwitterTrendingScraper.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.scrapper.TwitterTrendingScraper.dtos.TrendResponseDto;
import com.twitter.scrapper.TwitterTrendingScraper.models.TrendModel;
import com.twitter.scrapper.TwitterTrendingScraper.repositories.TrendRepository;

@Service
public class TrendServices {
    @Autowired
    private TrendRepository trendsRepository;

    public TrendModel saveTrends(TrendResponseDto trendResponseDto) {
        return trendsRepository.save(new TrendModel(trendResponseDto.getTrends(), trendResponseDto.getEnDateTime(),
                trendResponseDto.getIpaddress()));
    }
}
