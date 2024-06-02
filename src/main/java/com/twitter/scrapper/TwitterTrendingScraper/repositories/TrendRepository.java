package com.twitter.scrapper.TwitterTrendingScraper.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.twitter.scrapper.TwitterTrendingScraper.models.TrendModel;

@Repository
public interface TrendRepository extends MongoRepository<TrendModel, String> {

}
