package com.xiaor.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xiaor.pojo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    private static Logger log = LoggerFactory.getLogger(LoginCheckInterceptor.class);

    @Override // 目标资源运行前运行,返回true,放行,返回false,不放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
//        return HandlerInterceptor.super.preHandle(request, response, handler);
        System.out.println("preHandle...");
        // 登录校验

        // 1. 获取请求url
        String url = req.getRequestURI().toString();
        log.info("请求的url" + url);

        // 2. 判断url中是否包含login, 包含则为登录操作,放行
        if (url.contains("login")) {
            log.info("登录操作,放行......");
            return true;
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
            return false;
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
//            return false;
//        }

        // 6. 放行
        log.info("令牌合法,放行~");
        return true;
    }

    @Override    // 目标资源运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("postHandle...");
    }

    @Override       // 视图渲染完毕后运行,最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("afterCompletion...");
    }
}
