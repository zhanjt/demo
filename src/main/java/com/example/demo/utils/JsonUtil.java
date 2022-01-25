package com.example.demo.utils;

import com.example.demo.shardingJdbc.User;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * <功能说明>
 * 自己封装json工具类，使用spring自带的jackson，用于代替fastjson，
 * 避免因使用fastjson经常安全扫描不通过的问题
 * @JsonIgnore注解是在序列化时忽略该字段
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/5/18  | 修改内容
 */

public class JsonUtil<T> {
    @JsonPropertyOrder(alphabetic = true)
    private static final ObjectMapper objectMapper = new ObjectMapper();


    static {
        //排序：java自己写的实体类用这两个排序配置就可以了，但是自己转的jsonNode无法排序，需要转成Object对象才可以
        objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        objectMapper.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
//        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    //java对象转json字符串
    public static String object2JsonStr(Object obj){
        if(obj == null){
            return null;
        }
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

    //json字符串转json对象
    public static JsonNode str2JSONNode(String str){
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

    /**
     * json字符串转成特定类型的对象
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T str2Object(String str, Class<T> clazz){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        try {
            return objectMapper.readValue(str, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取属性值字符串，为空时返回 "",避免空指针
     * @param jsonNode
     * @param propertyName
     * @return
     */
    public static String getPropertyStr(JsonNode jsonNode, String propertyName){
        return jsonNode.get(propertyName) == null ? "" : jsonNode.get(propertyName).asText();
    }


    public static void main(String[] args) throws JsonProcessingException {
        User user = new User();
        user.setId(1L);
        user.setUsername("测试");
        user.setCity("福州");
        user.setCreateTime(new Date());
        user.setModifyTime(new Date());
//        user.setTestDate(LocalDateTime.now());
        String userStr = object2JsonStr(user);
        System.out.println(userStr);
        JsonNode userNode = str2JSONObject(userStr);
        User user4 = objectMapper.readValue(userStr, User.class);
        System.out.println(user4);
        //空测试,返回字符串"null"
        System.out.println(object2JsonStr(null));

        String str = "{\"id\":1,\"city\":\"福州\",\"username\":\"测试\",\"createTime\":\"2021-05-24 14:44:01\",\"modifyTime\":\"2021-05-24 14:44:01\"}";
        JsonNode jsonNode = str2JSONObject(str);
        System.out.println(jsonNode.get("createTime").asText());
        System.out.println(jsonNode.get("id").asInt());
        //测试空字符串,会抛异常 java.lang.NullPointerException
//        String str2 = null;
//        JsonNode jsonNode2 = str2JSONObject(str2);
//        System.out.println(jsonNode2.get("test"));


        List<User> list = new ArrayList<>();
        User user1 = new User(1L, "福州", "阿福");
        User user2 = new User(2L, "福州", "阿福2");
        User user3 = new User(3L, "福州", "阿福3");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        String listStr = object2JsonStr(list);
        System.out.println(listStr);
        List list1 = str2Object(listStr, List.class);
        list1.stream().forEach(u -> System.out.println(u));

//        String sss = "sss";
//        System.out.println(str2JSONObject(sss));


        String jsonStr = "{\"SERVICE_NAME\":\"issue-fwd\",\"SC_MARK\":\"MA1\",\"EXEC_TIME\":\"24\",\"RESPONSE_STR\":\"{\\\"bizPackage\\\":{\\\"bizSerialNo\\\":\\\"RA0862021073011575005824\\\",\\\"data\\\":{},\\\"resultCode\\\":\\\"S0300001\\\",\\\"resultDesc\\\":\\\"系统异常\\\"},\\\"sign\\\":\\\"MEYCIQD6sWqD2tebYDXrjarDnIK2svBmc+7Xybimhs7MHedwfgIhAL36k24J+/uSoOMFmHXu1HvPyIQv1WVfGjasSMRh+5Ut\\\"}\",\"BUSINESS_RESULT_CODE\":\"S0300001\",\"OUTSIDE_API_CALL_DESC\":\"{\\\"http://10.24.37.115:10006/mops-server/p1/sign\\\":{\\\"start_time\\\":\\\"20210730115800748\\\",\\\"responseResult\\\":{\\\"data\\\":{\\\"signature\\\":\\\"MEYCIQD6sWqD2tebYDXrjarDnIK2svBmc+7Xybimhs7MHedwfgIhAL36k24J+/uSoOMFmHXu1HvPyIQv1WVfGjasSMRh+5Ut\\\",\\\"certSeq\\\":\\\"21027fe615d5e74a\\\"},\\\"bizSerialNo\\\":\\\"RA0862021073011575005824\\\",\\\"resultCode\\\":\\\"M000000\\\",\\\"resultDesc\\\":\\\"操作成功\\\"},\\\"cost_time\\\":\\\"15\\\",\\\"end_time\\\":\\\"20210730115800763\\\",\\\"resultCode\\\":\\\"M000000\\\",\\\"params\\\":{\\\"bizSerialNo\\\":\\\"RA0862021073011575005824\\\",\\\"signAlgo\\\":\\\"\\\",\\\"signature\\\":\\\"\\\",\\\"appId\\\":\\\"APP_C6699BF15EBF4A43AF074F59F867B843\\\",\\\"bizData\\\":{\\\"bizType\\\":\\\"11\\\",\\\"source\\\":\\\"eyJiaXpTZXJpYWxObyI6IlJBMDg2MjAyMTA3MzAxMTU3NTAwNTgyNCIsImRhdGEiOnt9LCJyZXN1bHRDb2RlIjoiUzAzMDAwMDEiLCJyZXN1bHREZXNjIjoi57O757uf5byC5bi4In0=\\\"},\\\"deviceId\\\":\\\"\\\",\\\"version\\\":\\\"\\\"},\\\"resultDesc\\\":\\\"操作成功\\\"},\\\"http://10.24.37.115:10006/mops-server/envelope/decrypt\\\":{\\\"start_time\\\":\\\"20210730115800739\\\",\\\"responseResult\\\":{\\\"data\\\":[],\\\"bizSerialNo\\\":\\\"RA0862021073011575005824\\\",\\\"resultCode\\\":\\\"M010001\\\",\\\"resultDesc\\\":\\\"参数异常:encrypt\\\"},\\\"cost_time\\\":\\\"8\\\",\\\"end_time\\\":\\\"20210730115800747\\\",\\\"resultCode\\\":\\\"M010001\\\",\\\"params\\\":{\\\"bizSerialNo\\\":\\\"RA0862021073011575005824\\\",\\\"appId\\\":\\\"APP_C6699BF15EBF4A43AF074F59F867B843\\\",\\\"bizData\\\":{\\\"encrypt\\\":\\\"{}\\\"}},\\\"resultDesc\\\":\\\"参数异常:encrypt\\\"}}\",\"BIZ_TYPE\":\"issue\",\"REQUEST_TIME\":\"20210730115800739\",\"TABLE\":\"T_INTERFACE_OUT_AUTH_LOG\",\"ERR_CODE\":\"I020003\",\"IP_PORT\":\"192.16.0.86:6443\",\"ERR_DESC\":\"参数异常:encrypt\",\"FUNCTION_NAME\":\"request\",\"REQUEST_STR\":\"{\\\"bizPackage\\\":{\\\"appName\\\":\\\"00000001\\\",\\\"bioFlag\\\":\\\"1\\\",\\\"bizSerialNo\\\":\\\"RA0862021073011575005824\\\",\\\"issueData\\\":{},\\\"issuePhotoData\\\":\\\"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\\\",\\\"timestamp\\\":\\\"20210730115834825\\\"}}\",\"SUCCESS_FLAG\":false,\"RESPONSE_TIME\":\"20210730115800763\",\"UUID\":\"49a2a893d9bf46078ead8ef7c0863e49\",\"BSN\":\"RA0862021073011575005824\"}";
        JsonNode jsonObj = str2JSONObject(jsonStr);
        System.out.println(objectMapper.writeValueAsString(jsonObj));
        String bsn = getPropertyStr(jsonObj, "BSN");
        //判断是否为空
        System.out.println(jsonObj.hasNonNull("BSN1"));
        System.out.println(jsonObj.has("BSN1"));

        String dataStr = "{\"data\":{\"port\":\"18200\",\"ip\":\"15.1.6.41\",\"info\":[{\"property\":{\"TOTAL\":272,\"RT\":175,\"TPS\":11,\"FR_I\":1,\"FR_B\":3,\"FR_A\":5},\"beginTime\":1624500200000,\"endTime\":1624500205000,\"url\":\"/atom/idinfo_verify/by_dn_id_name\"}]},\"type\":\"1\"}";
        JsonNode dataNode = str2JSONObject(dataStr);
        JsonNode data = dataNode.findValue("data");
        //注意：需要转成Object对象才可以排序
        System.out.println(objectMapper.writeValueAsString(objectMapper.convertValue(dataNode.get("data"), Object.class)));
        System.out.println("-------");

        Iterator<Map.Entry<String, JsonNode>> it = data.fields();
        while (it.hasNext()){
            Map.Entry<String, JsonNode> entry = it.next();
            System.out.println(entry);
        }
        System.out.println(data);
        System.out.println(dataNode.get("type").asText());


        System.out.println("------");

        String json = "{\"SERVICE_NAME\":\"license\",\"SC_MARK\":\"MA1\",\"EXEC_TIME\":\"3\",\"RESPONSE_STR\":\"{\\\"bizSerialNo\\\":\\\"RA2002021101409555802356\\\",\\\"data\\\":{},\\\"resultCode\\\":\\\"A000000\\\",\\\"resultDesc\\\":\\\"请求成功\\\"}\",\"REQUEST_URL\":\"/uentrance/atom/license/flowLimitCountIncreaseOnce\",\"REQUEST_TIME\":\"20211014095558265\",\"TABLE\":\"T_ATOM_LOG\",\"ERR_CODE\":\"A000000\",\"IP_PORT\":\"192.16.0.222:6080\",\"ERR_DESC\":\"请求成功\",\"FUNCTION_NAME\":\"flowLimitCountIncrease\",\"REQUEST_STR\":\"{\\\"bizData\\\":{\\\"bizType\\\":\\\"1\\\",\\\"customerNo\\\":\\\"ywzd98\\\",\\\"mode\\\":\\\"H01\\\"},\\\"bizSerialNo\\\":\\\"RA2002021101409555802356\\\"}\",\"RESPONSE_TIME\":\"20211014095558268\",\"UUID\":\"85c29fb06e22433f857ffc61d5e1935d\",\"BSN\":\"RA2002021101409555802356\"}";
        JsonNode jsonObj22 = JsonUtil.str2JSONNode(json.substring(json.indexOf('{')));
        String requestUrl=JsonUtil.getPropertyStr(jsonObj22, "REQUEST_URL");
        System.out.println(">>>>atom url: " + requestUrl);
    }




}
