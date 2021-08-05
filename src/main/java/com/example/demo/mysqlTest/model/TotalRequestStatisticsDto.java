package com.example.demo.mysqlTest.model;

import lombok.Data;

@Data
public class TotalRequestStatisticsDto {

    private String statisticsTime;

    private String businessSiteNumber;

    private Integer requestQuantity;

    private String updateTime;
}