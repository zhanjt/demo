package com.example.demo.java8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/7/12  | 修改内容
 */
public class StringTest {

    public static void main(String[] args) {
//        List<String> list = null;
//        System.out.println(String.join(",", list));



//        String[] currentTimeBefores = new String[5];
//        LocalDateTime currentTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
//        for (int i = 5; i < 10; i++) {
//            String currentTimeBefore = currentTime.minusMinutes(i).format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
//            currentTimeBefores[i - 5] = currentTimeBefore;
//        }
//        for (String s: currentTimeBefores){
//
//            System.out.println(s);
//        }

        //        List<String> list = Arrays.asList("test001","test002","test003","test004","test005");
//        System.out.println(list.subList(0,0));

        String str = "ERROR_111__192.168.10.1:6080_A020001";
        String filedKey = str.substring(0, str.lastIndexOf('_'));
        System.out.println(filedKey);
        String filedKey2 = str.substring(str.lastIndexOf('_')+1);
        System.out.println(filedKey2);
        String[] keys = str.split("_");
        System.out.println(keys.length);
        for (String key: keys){
            System.out.println(key);

        }

        String str2 = "codis-maintenance:300-hash-auth2RA1d3969308518479284ac766f159c0ffb";
        System.out.println(str2.substring(str2.lastIndexOf("codis-maintenance:") + "codis-maintenance".length() + 1));
    }
}
