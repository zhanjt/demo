package com.example.demo.javaTest;

import com.example.demo.utils.JsonUtil;

import java.util.Hashtable;
import java.util.Map;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/12/13  | 修改内容
 */
public class HashTableTest {

    public static void main(String[] args) {
        Hashtable<String, Boolean> table = new Hashtable<>();

        table.put("test1", false);
        table.put("test2", true);
        table.put("test3", true);
        table.put("test4", true);
        System.out.println(JsonUtil.object2JsonStr(table));
        table.put("test4", false);
        System.out.println("--------------");
        System.out.println(JsonUtil.object2JsonStr(table));
        table = new Hashtable<>();
        System.out.println("--------------");
        System.out.println(JsonUtil.object2JsonStr(table));

    }
}
