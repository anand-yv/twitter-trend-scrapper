package com.twitter.scrapper.TwitterTrendingScraper.models;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("trends")
public class TrendModel {
    @Id
    private String id; // Unique ID

    private List<String> trends;
    private LocalDateTime endTime;
    private String ipAddress;

    // Constructors, getters, and setters

    public TrendModel() {
        // Default constructor
    }

    public TrendModel(List<String> trends, LocalDateTime endTime, String ipAddress) {
        this.trends = trends;
        this.endTime = endTime;
        this.ipAddress = ipAddress;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTrends() {
        return trends;
    }

    public void setTrends(List<String> trends) {
        this.trends = trends;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
