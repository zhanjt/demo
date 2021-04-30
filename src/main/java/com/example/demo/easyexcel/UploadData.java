package com.example.demo.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <功能说明>
 * 基础数据类
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/4/28  | 修改内容
 */
@Data
public class UploadData {
    private String functionName;
    private String serviceName;
    private Date date;
    private Double doubleData;


    @ExcelProperty("告警内容")
    private String alarmContext;
    @ExcelProperty("告警级别")
    private String alarmLevel;
    @ExcelProperty("是否完结")
    private String end;
    @ExcelProperty("创建时间")
    private String createDate;

}
