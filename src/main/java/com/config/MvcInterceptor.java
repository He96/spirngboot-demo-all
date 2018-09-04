package com.config;

import com.util.AllowPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Component
public class MvcInterceptor implements HandlerInterceptor {

    @Autowired
    LoginContext loginContext;

    //请求发生前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        response.setCharacterEncoding("utf-8");
        //加了AllowPass注解的运行通过
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            //自定义通过权限
            AllowPass allowPass = method.getAnnotation(AllowPass.class);
            if (allowPass != null) {
                return true;
            }
            //登录权限判断
            if(loginContext.isAuthorized()){
                return true;
            }else{
               //api调用
                response.setStatus(401);
                //页面调用
                return false;
            }
        }
        return true;
    }

    //请求完成后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long time = (System.currentTimeMillis() - (Long) request.getAttribute("startTime"));
        System.out.println("本次请求处理时间:" + time + "ms");
        request.setAttribute("handlingTime", time);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
