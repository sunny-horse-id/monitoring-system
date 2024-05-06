package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//告诉SpringBoot这个类是用于处理异常的
@RestControllerAdvice
public class GlobalExceptionHandler {
    //指定错误类型，这里是所有的异常
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        //因为有部分异常没有信息，所有借助StringUtils.hasLength来进行判断
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "未知错误");
    }
}
