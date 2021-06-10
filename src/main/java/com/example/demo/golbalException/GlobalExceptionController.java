package com.example.demo.golbalException;

import com.example.demo.shardingJdbc.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/10  | 修改内容
 */
@RestController
public class GlobalExceptionController {

    @GetMapping("/errTest")
    public Result errTest(Integer i){
        int j = 1 / i;
        return Result.success();
    }

    @PostMapping("/errTestParams")
    public Result errTestParams(@RequestBody @Validated User user, BindingResult bindingResult){
        ParameterValidated.validData(bindingResult);
        return Result.success();
    }


}
