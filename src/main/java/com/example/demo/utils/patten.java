package com.example.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <功能说明>
 * 正则校验
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/11/18  | 修改内容
 */
public class patten {

    private static Pattern URL_PATTERN = Pattern.compile("^\\/([a-z\\\\/-]{1,99})(?<![\\\\/|\\\\-])$");
    private static Pattern PHONE_PATTERN = Pattern.compile("^1(?:3\\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\\d|9\\d)\\d{8}$");

    public static void main(String[] args) {
        String urlStr = "/maintenance/manager/basemanage/module/new-";
        Matcher matcher = URL_PATTERN.matcher(urlStr);
        if(matcher.matches()){
            System.out.println(">>>hello world");
        }

        if(PHONE_PATTERN.matcher("18888888888").matches()){
            System.out.println(true);
        }
    }



}
