package com.xiaor.aop;

import java.lang.System;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class TimeAspect {
    private static Logger log = LoggerFactory.getLogger(TimeAspect.class);

    @Around("execution(* com.xiaor.service.*.*(..))")   // 切入点表达式: 表明哪些方法会执行recordTime方法
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 记录开始时间
        long startTime = System.currentTimeMillis();

        // 2. 调用原始方法运行
        Object result = joinPoint.proceed();

        // 3. 记录结束时间
        long endTime = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "方法执行耗时: {}ms", endTime - startTime);

        return result;
    }
}
