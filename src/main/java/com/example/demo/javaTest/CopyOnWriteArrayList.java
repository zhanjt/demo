package com.example.demo.javaTest;

import com.example.demo.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/12/13  | 修改内容
 */
public class CopyOnWriteArrayList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        System.out.println(JsonUtil.object2JsonStr(list));

        list.clear();
        System.out.println(JsonUtil.object2JsonStr(list));
    }
}
