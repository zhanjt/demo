package com.example.demo.golbalException;

import lombok.Data;

/**
 * <功能说明>
 * 返回值定义
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/10  | 修改内容
 */
@Data
public class Result {

    private String code;

    private String mdg;

    private Object data;

    public Result(String code, String mdg, Object data) {
        this.code = code;
        this.mdg = mdg;
        this.data = data;
    }

    public static Result success(){
        return success(null);
    }

    public static Result success(Object data){
        return new Result(ResultCodeEnum.OK.getCode(), ResultCodeEnum.OK.getMsg(), data);
    }

    public static Result error(String code, String msg){
        return error(code, msg, null);
    }

    public static Result error(String code, String msg,Object data){
        return new Result(code, msg, data);
    }

    public static Result systemError(){
        return error(ResultCodeEnum.SYSTEM_EXCEPTION.getCode(), ResultCodeEnum.SYSTEM_EXCEPTION.getMsg());
    }

}
