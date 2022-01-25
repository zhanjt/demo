package com.example.demo.javaTest;

import com.example.demo.utils.JsonUtil;

import java.util.Map;
import java.util.Set;
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
//        Map<String, String> map2 = new ConcurrentHashMap<>();
//        Map<String, String> map3 = new ConcurrentHashMap<>();
//
//        mapSummary(map1, map2, map3);
//
//        Integer ints = null;
//        System.out.println("" + ints);
//        System.out.println(ints + "");

//        String filedKey = new StringBuilder("357").append(":").append(":").append("15.1.9.5:6080").toString();
//        map1.put(filedKey, "true");
//        String filedKey2 = new StringBuilder("354").append(":").append(":").append("15.1.9.5:6080").toString();
//        System.out.println(filedKey);
//        System.out.println(map1.get(filedKey));
//        System.out.println(map1.get(filedKey2));

        addMap(map1);
        String[] strings = map1.keySet().toArray(new String[0]);
        System.out.println(JsonUtil.object2JsonStr(strings));
        for (Map.Entry<String, String> map : map1.entrySet()){
            if(map.getKey().equals("key2")){
                map1.remove(map.getKey());
                System.out.println("aaa");
            }
        }
        mapSummary(map1);
    }

    private static Map<String, Integer> mapSummary(Map<String, String>... map){
        for(int i = 0; i < map.length; i++){
            System.out.println(map[i]);
        }
        return null;
    }

    private static void addMap(Map<String, String> map1){
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map1.put("key3", "value3");
        map1.put("key4", "value4");
    }
}
