package com.example.demo.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/7/9  | 修改内容
 */
public class JsonTest {

    public static void main(String[] args) {
        String str = "{\"headers\":{\"date\":\"20210708\",\"path\":\"/20210708/LZY456789012345678901236\",\"partition\":\"1\",\"alternatekey\":\"T_INTERFACE_IN_LOG\",\"topic\":\"T_INTERFACE_IN_LOG\",\"SN\":\"LZY456789012345678901236\",\"timestamp\":\"1625725975534\"},\"body\":\"{\\\"TABLE\\\":\\\"T_INTERFACE_IN_LOG\\\",\\\"SERVICE_NAME\\\":\\\"authen-fwd\\\",\\\"IP_PORT\\\":\\\"192.16.0.181:6080\\\",\\\"FUNCTION_NAME\\\":\\\"request\\\",\\\"SC_MARK\\\":\\\"MA1\\\",\\\"CUSTOMER_NO\\\":\\\"rzfw01\\\",\\\"BIZ_MODE\\\":\\\"R24\\\",\\\"UUID\\\":\\\"0e8e86672d474916a09389a2f59453f0\\\",\\\"BIZ_TYPE\\\":\\\"authen\\\",\\\"BSN\\\":\\\"LZY456789012345678901236\\\",\\\"REQUEST_TIME\\\":\\\"20210708143254031\\\"}\"}*_*";
        JSONObject jsonObject = JSONObject.parseObject(str.substring(str.indexOf("{"), str.lastIndexOf("}") + 1));
        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.getJSONObject("body").toJSONString());
    }

}
