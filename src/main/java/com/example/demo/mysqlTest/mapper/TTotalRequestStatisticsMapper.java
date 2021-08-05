package com.example.demo.mysqlTest.mapper;

import com.example.demo.mysqlTest.model.TTotalRequestStatistics;
import com.example.demo.mysqlTest.model.TotalRequestStatisticsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TTotalRequestStatisticsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TTotalRequestStatistics record);

    int insertSelective(TTotalRequestStatistics record);

    TTotalRequestStatistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TTotalRequestStatistics record);

    int updateByPrimaryKey(TTotalRequestStatistics record);

    List<TTotalRequestStatistics> selectBySelective(TotalRequestStatisticsDto record);


    int insertBatch(List<TTotalRequestStatistics> list);

    int updateBatch(List<TTotalRequestStatistics> list);

    List<TTotalRequestStatistics> selectBystatisticsTimeDesc(@Param("statisticsTime") String statisticsTime);
}