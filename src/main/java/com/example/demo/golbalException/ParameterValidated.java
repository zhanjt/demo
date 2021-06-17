package com.example.demo.golbalException;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.Set;


/**
 * <功能说明>
 * 参数校验类
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/10  | 修改内容
 */
public class ParameterValidated {


    /**
     * 简单校验
     * @param bindingResult
     */
    public static void validData(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer sb = new StringBuffer("【");
            int i = 0;
            for (ObjectError error : bindingResult.getAllErrors()) {
                sb.append(error.getDefaultMessage());
                i++;
                if(i < bindingResult.getAllErrors().size()){
                   sb.append(", ");
                }
            }
            sb.append("】");
            throw new BizException(ResultCodeEnum.PARAM_VALIDATE_FAIL.getCode(),sb.toString());
        }
    }

    /**
     * 实体类参数有效性验证
     * @param bean 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回true；验证失败：将错误信息添加到message中
     */
//    public void validObject(Object bean, Validator validator, Class<?> ...groups) {
//        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean, groups);
//        if (!constraintViolationSet.isEmpty()) {
//            StringBuilder sb = new StringBuilder();
//            for (ConstraintViolation violation: constraintViolationSet) {
//                sb.append(violation.getMessage());
//            }
//
//            throw new BizException(ResultCodeEnum.PARAM_VALIDATE_FAIL.getCode(),sb.toString());
//        }
//    }
}
