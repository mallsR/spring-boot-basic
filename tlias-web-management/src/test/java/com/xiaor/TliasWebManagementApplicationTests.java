//package com.xiaor;
//
//import com.xiaor.controller.DeptController;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@SpringBootTest
//class TliasWebManagementApplicationTests {
//
//    @Test
//    void contextLoads() {
//        System.out.println("test successfully");
//    }
//
//    /**
//     * 生成Jwt令牌
//     */
//    @Test
//    public void testGenJwt() {
//        Map<String, Object> claims = new HashMap<String, Object>();
//        claims.put("id", 17);
//        claims.put("name", "qianqian");
//
//        String jwt = Jwts.builder()
//                .signWith(SignatureAlgorithm.HS256, "2024060720240629202409142024100120241222xiaoRqianqian")    // 签名算法
//                .setClaims(claims)      // 自定义内容 : 载荷部分
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // 设置有效期为1h
//                .compact();
//        System.out.println(jwt);
//    }
//
////    @Test
////    public void testParseJwt() {
////        Claims claims = Jwts.parser()
////                .setSigningKey("2024060720240629202409142024100120241222xiaoRqianqian")
////                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoicWlhbnFpYW4iLCJpZCI6MTcsImV4cCI6MTczNzM0NTI0OX0.LdG2_T3jKWsTvRMSbJsPHMfeiVYixZ39Zm1Avqv-l3E")
////                .getBody();
////        System.out.println(claims);
////    }
//
//
//    // 测试获取bean
//    private ApplicationContext applicationContext;      //  注入IOC容器对象,用其获取bean对象
//
//    @Test
//    public void testGetBean() {
//        // 根据bean的名称获取
//        DeptController bean1 = (DeptController) applicationContext.getBean("deptController");
//        System.out.println(bean1);
//
//        // 根据bean的类型获取
//        DeptController bean2 = applicationContext.getBean(DeptController.class);
//        System.out.println(bean2);
//
//        // 根据bean的名称及类型获取
//        DeptController bean3 = applicationContext.getBean("deptController", DeptController.class);
//        System.out.println(bean3);
//    }
//
//
//    @Autowired
//    private SAXReader saxReader;        // 注入saxReader对象
//    // 第三方bean的管理
//    @Test
//    public void testThirdBean() throws Exception {
////        SAXReader saxReader = new SAXReader();  // 每次解析xml,都需要创建这个对象,耗费资源
//
//        Document document = saxReader.read(this.getClass().getClassLoader().getResource("test.xml"));
//        Element rootElement = document.getRootElement();
//        String name = rootElement.element("name").getText();
//        String age = rootElement.element("age").getText();
//
//        System.out.println(name + " " + age);
//    }
//
//    @Test
//    public void testGetBean2() {
//        Object saxReader = applicationContext.getBean("saxReader");
//        System.out.println(saxReader);
//    }
//}
