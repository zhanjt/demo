package com.example.demo.javaTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * <功能说明>
 *  map测试
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/9  | 修改内容
 */
public class MapTest {


    public static void main(String[] args) {
        Map<String, String> map1 = new ConcurrentHashMap<>();
        Map<String, String> map2 = new ConcurrentHashMap<>();
        Map<String, String> map3 = new ConcurrentHashMap<>();

        mapSummary(map1, map2, map3);
    }

    private static Map<String, Integer> mapSummary(Map<String, String>... map){
        for(int i = 0; i < map.length; i++){
            System.out.println(map[i]);
        }
        return null;
    }
}
