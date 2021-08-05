package com.example.demo.mysqlTest.model;

import java.util.Date;

public class TTotalRequestStatistics {
    private Integer id;

    private Date statisticsTime;

    private String businessSiteNumber;

    private Integer requestQuantity;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStatisticsTime() {
        return statisticsTime;
    }

    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

    public String getBusinessSiteNumber() {
        return businessSiteNumber;
    }

    public void setBusinessSiteNumber(String businessSiteNumber) {
        this.businessSiteNumber = businessSiteNumber == null ? null : businessSiteNumber.trim();
    }

    public Integer getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(Integer requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}