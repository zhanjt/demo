package com.example.demo.mysqlTest.service;

import com.example.demo.mysqlTest.model.TotalRequestStatisticsDto;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/7/16  | 修改内容
 */
public interface TotalRequestService {

    void insertBatch(List<TotalRequestStatisticsDto> list);

    void insertOrUpdate(Map<String, Integer> allMap) throws ParseException;
}
