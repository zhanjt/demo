package com.example.demo.mysqlTest.controller;

import com.example.demo.golbalException.Result;
import com.example.demo.mysqlTest.model.TotalRequestStatisticsDto;
import com.example.demo.mysqlTest.service.TotalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/totalRequest")
public class TotalRequestController {

    @Autowired
    private TotalRequestService totalRequestService;
    @PostMapping("/insertBatch")
    public Result insertBatch(@RequestBody List<TotalRequestStatisticsDto> list){
        totalRequestService.insertBatch(list);
        return Result.success();
    }

    @PostMapping("/insertOrUpdate")
    private Result insertOrUpdate(@RequestBody Map<String, Integer> allMap) throws ParseException {
        totalRequestService.insertOrUpdate(allMap);
        return Result.success();
    }

}
