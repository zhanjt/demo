package com.example.demo.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <功能说明>
 * easyexcel读取数据监听类
 * easyexcel重写了poi对07版Excel的解析，能够原本一个3M的excel用POI sax依然需要100M左右内存降低到KB级别，并且再大的excel不会出现内存溢出，
 * 03版依赖POI的sax模式。在上层做了模型转换的封装，让使用者更加简单方便

 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/15  | 修改内容
 */
@Slf4j
public class ExcelListener extends AnalysisEventListener {

    private final List<Object> list = new ArrayList();

    @Override
    public void invoke(Object data, AnalysisContext context) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("read {} list %n", list.size());
    }

    //外部获取excel数据
    public List<Object> getList(){
        return list;
    }
}
