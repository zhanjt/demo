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
public class DownloadData {

    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;
}
