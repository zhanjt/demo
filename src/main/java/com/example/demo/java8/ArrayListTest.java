package com.example.demo.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/8/4  | 修改内容
 */
public class ArrayListTest {

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();

        String[] testStr = {"202108041350", "202108041350", "202108041350", "202108041350","202108031350"};
        for (String str : testStr) {
            String key = str.substring(0,8);
            List<String> dateMinitesList = map.get(key);
            if(dateMinitesList == null || dateMinitesList.isEmpty()){
                dateMinitesList = new ArrayList<>();
                map.put(key, dateMinitesList);
            }
            dateMinitesList.add(str);
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + String.join(",", entry.getValue()));
        }
    }
}
