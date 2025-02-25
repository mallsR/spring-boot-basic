package com.xiaor.exception;

import com.xiaor.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)  // 指定捕获所有异常
    public Result exception(Exception ex) {
        ex.printStackTrace();       // 异常的堆栈信息
        return Result.error("对不起,操作失败,请联系管理员.");
    }
}
