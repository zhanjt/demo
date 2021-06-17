package com.example.demo.golbalException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <功能说明>
 * 全局异常捕获
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/6/10  | 修改内容
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        if (log.isDebugEnabled()) {
            log.debug("请求参数校验不通过: " + e.getParameterName() + "参数未提供", e);
        }
        return Result.error(ResultCodeEnum.PARAM_VALIDATE_FAIL.getCode(), e.getParameterName() + "参数未提供");
    }

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception ex) {
        String requestURI = request.getRequestURI();
        log.error("请求：" + requestURI + ",全局异常处理", ex);

        if (ex instanceof BizException) {
            return Result.error(((BizException) ex).getCode(), ((BizException) ex).getMsg());
        }
        return Result.systemError();
    }

}
