package com.example.demo.golbalException;

import com.example.demo.shardingJdbc.User;
import org.springframework.stereotype.Service;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/11  | 修改内容
 */
@Service
public class GlobalService {

    public String validateTest(User user){
        throw new BizException(ResultCodeEnum.SYSTEM_EXCEPTION.getCode(), ResultCodeEnum.SYSTEM_EXCEPTION.getMsg());
//        return "success";
    }
}
