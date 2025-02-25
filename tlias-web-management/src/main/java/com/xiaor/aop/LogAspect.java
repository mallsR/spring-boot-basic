package com.xiaor.aop;

import com.alibaba.fastjson.JSONObject;
import com.xiaor.mapper.OperateLogMapper;
import com.xiaor.pojo.OperateLog;
import com.xiaor.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

//@Slf4j
@Component      // 交由IOC容器管理
@Aspect     // 切面类
public class LogAspect {
    private static Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private HttpServletRequest request;     // 注入http请求类

    @Autowired
    private OperateLogMapper operateLogMapper;      // 注入日志操作记录对象

    @Around("@annotation(com.xiaor.anno.Log)")      // 环绕注解
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取操作信息
        // 操作人的ID - 当前登录员工ID : 通过jwt令牌获取
//        String jwt = request.getHeader("token");
//        Claims claims = JwtUtils.parseJWT(jwt);
//        Integer operateUser = (Integer) claims.get("id");
        Integer operateUser = 17;

        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        // 操作类名
        String className = joinPoint.getTarget().getClass().getName();

        // 操作方法名
        String methodName = joinPoint.getSignature().getName();

        // 操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParms = Arrays.toString(args);     // 将参数转为字符串

        // 开始时间
        long startTime = System.currentTimeMillis();

        // 调用原始目标方法运行
        Object result = joinPoint.proceed();

        // 方法返回值
        String returnValue = JSONObject.toJSONString(result);

        // 操作耗时
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;

        // 记录操作日志
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime,
                className, methodName, methodParms, returnValue, executeTime);
        operateLogMapper.insert(operateLog);

        log.info("AOP操作日志: {}", operateLog);

        return result;
    }
}
