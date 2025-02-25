package com.xiaor.anno;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)     // 指定注解运行的时候才生效
@Target(ElementType.METHOD)     // 指定注解生效的地方
public @interface Log {


}
