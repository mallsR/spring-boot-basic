package com.xiaor.config;

import com.xiaor.service.DeptService;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      // 配置类
public class CommomConfig {

    // 声明第三方bean
    @Bean       // 将当前方法的返回值对象交给IOC容器管理,称为IOC容器bean
    // 通过@Bean注解的value/name属性指定bean名称,如果未指定,默认为方法名
    public SAXReader saxReader(DeptService deptService) {       // 如果第三方bean需要bean对象,可以直接通过参数传入的形式,让IOC容器实现注入
        System.out.println(deptService);
        return new SAXReader();
    }
}
