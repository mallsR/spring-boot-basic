package com.xiaor.controller;

import com.xiaor.pojo.Emp;
import com.xiaor.pojo.Result;
import com.xiaor.service.EmpService;
import com.xiaor.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    // 日志记录对象
    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    // 注入用户对象
    @Autowired
    private EmpService empService;

    /**
     * 用户登录功能
     * @param emp
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("用户登录, 参数 : {}", emp);
        Emp user = empService.login(emp);
        // 用户信息正确,生成并下发jwt令牌
        if (user != null) {
            // 封装用户信息
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("name", user.getName());
            claims.put("username", user.getUsername());
//            claims.put("password", user.getPassword());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
