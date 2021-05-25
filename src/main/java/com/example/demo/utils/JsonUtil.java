package com.example.demo.utils;

import com.example.demo.shardingJdbc.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <功能说明>
 * 自己封装json工具类，使用spring自带的jackson，用于代替fastjson，
 * 避免因使用fastjson经常安全扫描不通过的问题
 * @JsonIgnore注解是在序列化时忽略该字段
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/5/18  | 修改内容
 */
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    //java对象转json字符串
    public static String object2JsonStr(Object obj){
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e){
            //转换错误异常抛出
            e.printStackTrace();
        }
        return null;
    }

    //json字符串转json对象
    public static JsonNode str2JSONObject(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        try {
            return objectMapper.readTree(str);
        }catch (Exception e){
            //转换错误异常抛出
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setUsername("测试");
        user.setCity("福州");
        user.setCreateTime(new Date());
        user.setModifyTime(new Date());
        user.setTestDate(LocalDateTime.now());
        System.out.println(object2JsonStr(user));
        //空测试,返回字符串"null"
        System.out.println(object2JsonStr(null));

        String str = "{\"id\":1,\"city\":\"福州\",\"username\":\"测试\",\"createTime\":\"2021-05-24 14:44:01\",\"modifyTime\":\"2021-05-24 14:44:01\"}";
        JsonNode jsonNode = str2JSONObject(str);
        System.out.println(jsonNode.get("createTime").asText());
        //测试空字符串,会抛异常
//        String str2 = null;
//        JsonNode jsonNode2 = str2JSONObject(str2);
//        System.out.println(jsonNode2.get("test"));
    }




}
