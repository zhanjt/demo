package com.example.demo.mysqlTest.service.impl;

import com.example.demo.mysqlTest.mapper.TTotalRequestStatisticsMapper;
import com.example.demo.mysqlTest.model.TTotalRequestStatistics;
import com.example.demo.mysqlTest.model.TotalRequestStatisticsDto;
import com.example.demo.mysqlTest.service.TotalRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/7/16  | 修改内容
 */
@Service
@Slf4j
public class TotalRequestServiceImpl implements TotalRequestService {

    @Autowired
    private TTotalRequestStatisticsMapper totalRequestStatisticsMapper;

    private SimpleDateFormat yyyyMMddFormat = new SimpleDateFormat("yyyyMMdd");

    /**
     * 批量插入测试
     * @param list
     */
    @Override
    public void insertBatch(List<TotalRequestStatisticsDto> list) {
        try {
            List<TTotalRequestStatistics> lists = new ArrayList<>();
            for (TotalRequestStatisticsDto dto: list) {
                TTotalRequestStatistics statistics = new TTotalRequestStatistics();
                statistics.setBusinessSiteNumber(dto.getBusinessSiteNumber());
                statistics.setRequestQuantity(dto.getRequestQuantity());
                statistics.setStatisticsTime(yyyyMMddFormat.parse(dto.getStatisticsTime()));
                statistics.setUpdateTime(new Date());
                lists.add(statistics);
            }

            totalRequestStatisticsMapper.insertBatch(lists);
        }catch (Exception e){
            log.error("批量插入书库看异常", e);
        }
    }

    /**
     * 测试一下判断是否已经有记录
     */
    @Override
    public void insertOrUpdate(Map<String, Integer> allMap) throws ParseException {
        String dateStr = "20210721";
        List<TTotalRequestStatistics> addList = new CopyOnWriteArrayList<>();
        List<TTotalRequestStatistics> updateList = new CopyOnWriteArrayList<>();
        Integer value = null;
        String key = null;
        //查询数据库是否已经存在该记录
        TotalRequestStatisticsDto statistics = new TotalRequestStatisticsDto();
        statistics.setStatisticsTime(dateStr);
        List<TTotalRequestStatistics> list = totalRequestStatisticsMapper.selectBySelective(statistics);

        for (Map.Entry<String, Integer> entry : allMap.entrySet()) {
            value = entry.getValue();
            if (value == null || value == 0) {
                continue;
            }
            key = entry.getKey();
            //TODO 业务站点号太长的，先去掉吧
            if (key.length() > 32) {
                continue;
            }
            TTotalRequestStatistics record = null;
            if (list != null && !list.isEmpty()) {
                for (TTotalRequestStatistics bs : list) {
                    if (bs.getBusinessSiteNumber().equals(key)) {
                        record = new TTotalRequestStatistics();
                        BeanUtils.copyProperties(bs, record);
                        record.setRequestQuantity(bs.getRequestQuantity() + value);
                        record.setUpdateTime(new Date());
                        updateList.add(record);
                        break;
                    }
                }
            }
            if (record == null) {
                record = new TTotalRequestStatistics();
                record.setStatisticsTime(yyyyMMddFormat.parse(dateStr));
                record.setBusinessSiteNumber(key);
                record.setRequestQuantity(value);
                record.setUpdateTime(new Date());
                addList.add(record);
            }
            //批量插入或修改
            if (!updateList.isEmpty()) {
                totalRequestStatisticsMapper.updateBatch(updateList);
            }
            if (!addList.isEmpty()) {
                totalRequestStatisticsMapper.insertBatch(addList);
            }
        }



    }
}
