package com.xiaor;

import org.dom4j.io.SAXReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@ServletComponentScan
//@ComponentScan({"com.xiaor", "com.example"})
//@Import(TokenParser.class)  // 导入普通类
//@Import(HeaderParser.class)     // 导入配置类
//@Import(MyImportSelector.class)     // 导入ImportSelector接口实现类
//@EnableHeaderConfig     // 通过子模块自定义的注解,利用ImportSelector将所需的类导入: 方便优雅
@SpringBootApplication  // 只扫描当前包和子包
public class TliasWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebManagementApplication.class, args);
    }

//    // 声明第三方bean
//    @Bean       // 将当前方法的返回值对象交给IOC容器管理,称为IOC容器bean
//    // 通过@Bean注解的value/name属性指定bean名称,如果未指定,默认为方法名
//    public SAXReader saxReader() {       // 如果第三方bean需要bean对象,可以直接通过参数传入的形式,让IOC容器实现注入
////        System.out.println(deptService);
//        return new SAXReader();
//    }
}
