package com.xiaor.filter;

import com.alibaba.fastjson.JSONObject;
import com.xiaor.pojo.Result;
import com.xiaor.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;

//@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    private static Logger log = LoggerFactory.getLogger(LoginCheckFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        ;// 向下转型
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;

        // 1. 获取请求url
        String url = req.getRequestURI().toString();
        log.info("请求的url" + url);

        // 2. 判断url中是否包含login, 包含则为登录操作,放行
        if (url.contains("login")) {
            log.info("登录操作,放行......");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 3. 获取令牌(token)
        String jwt = req.getHeader("token");

        // 4. 令牌是否存在
        if (!StringUtils.hasText(jwt)) {
            log.info("请求头token为空,返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换 对象->json
            String notlogin = JSONObject.toJSONString(error);
            res.getWriter().write(notlogin);
            return;
        }

        // 5. 令牌错误
//        try {
//            JwtUtils.parseJWT(jwt);
//        } catch (Exception e) {
//            e.printStackTrace();       // 打印错误日志
//            log.info("解析令牌失败,返回未登录错误信息");
//            Result error = Result.error("NOT_LOGIN");
//            // 手动转换 对象->json
//            String notlogin = JSONObject.toJSONString(error);
//            res.getWriter().write(notlogin);
//            return;
//        }

        // 6. 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
