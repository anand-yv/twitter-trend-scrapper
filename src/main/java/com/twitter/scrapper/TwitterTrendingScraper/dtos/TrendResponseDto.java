package com.twitter.scrapper.TwitterTrendingScraper.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class TrendResponseDto {
    private List<String> trends;
    private String ipaddress;
    private LocalDateTime enDateTime;
    private String id;
    private boolean check;

    public TrendResponseDto(List<String> trends, String ipaddress, LocalDateTime enDateTime, String id, boolean check) {
        this.trends = trends;
        this.ipaddress = ipaddress;
        this.enDateTime = enDateTime;
        this.id = id;
        this.check = check;
    }

    public List<String> getTrends() {
        return trends;
    }

    public void setTrends(List<String> trends) {
        this.trends = trends;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public LocalDateTime getEnDateTime() {
        return enDateTime;
    }

    public void setEnDateTime(LocalDateTime enDateTime) {
        this.enDateTime = enDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

}
