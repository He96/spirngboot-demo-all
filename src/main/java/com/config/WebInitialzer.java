package com.config;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
//替代web.xml
@Component
public class WebInitialzer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("进入web文件配置");
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        //注册配置类并关联servletContext
        context.register(MvcConfig.class);
        context.setServletContext(servletContext);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher",
                new DispatcherServlet(context));
        //注册Spring MVC的DispatcherServlet
        registration.setLoadOnStartup(1);
        registration.setAsyncSupported(true);//开启异步方法支持
        registration.addMapping("/");
    }
}
