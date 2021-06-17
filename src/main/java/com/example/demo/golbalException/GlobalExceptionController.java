package com.example.demo.golbalException;

import com.example.demo.golbalException.validateGroup.DeleteGroup;
import com.example.demo.golbalException.validateGroup.UpdateGroup;
import com.example.demo.shardingJdbc.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/10  | 修改内容
 */
@RestController
public class GlobalExceptionController {

    @Autowired
    private GlobalService globalService;

    @GetMapping("/errTest")
    public Result errTest(@RequestParam @Validated Integer i, @RequestParam @Validated Integer k){
        int j = 1 / i;
        return Result.success();
    }

    @PostMapping("/errTestParams")
    public Result errTestParams(@RequestBody @Validated User user, BindingResult bindingResult){
        ParameterValidated.validData(bindingResult);
        globalService.validateTest(user);
        return Result.success();
    }

    @PostMapping("/errTestParamsGroup")
    public Result errTestParamsGroup(@RequestBody @Validated({UpdateGroup.class, DeleteGroup.class}) User user, BindingResult bindingResult){
        ParameterValidated.validData(bindingResult);
        return Result.success();
    }


}
