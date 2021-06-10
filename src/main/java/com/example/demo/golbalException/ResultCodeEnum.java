package com.example.demo.golbalException;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * <功能说明>
 * 返回码枚举类
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/10  | 修改内容
 */
public enum ResultCodeEnum {
    OK("000000", "success"),
    SYSTEM_EXCEPTION("999999", "系统异常"),

    PARAM_VALIDATE_FAIL("100000", "参数校验失败"),


    ;

    private String code;

    private String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
