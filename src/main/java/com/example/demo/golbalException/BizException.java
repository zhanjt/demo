package com.example.demo.golbalException;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/10  | 修改内容
 */
@Component
@Data
public class BizException extends RuntimeException {

    private String code;

    private String msg;


    public BizException() {
        super();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.msg = errorMsg;
    }

    public BizException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.code = errorCode;
        this.msg = errorMsg;
    }
}
