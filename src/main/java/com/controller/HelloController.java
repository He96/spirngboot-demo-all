package com.controller;

import com.entity.User;
import com.service.impl.PushService;
import com.util.ListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller//声明控制器
public class HelloController {
    @Autowired
    PushService pushService;

    //配置URL和方法之间的映射
    @RequestMapping(value = "no", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String noIn() {
        //通过ViewResolver的Bean配置，返回值为index
        return "此接口不被拦截";
    }

    //跳转news页面
    @RequestMapping(value = "toNewsPage", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView toNews() {
        ModelAndView modelAndView = new ModelAndView("news");
        modelAndView.addObject("msg", "Hello News Time");
        return modelAndView;
    }

    //跳转order页面
    @RequestMapping(value = "toOrder", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String toOrder() {
        return "order";
    }

    @RequestMapping("info")
    @ResponseBody
    public DeferredResult<String> deferredResult() {
        return pushService.getAsyncData();
    }

    /**
     * 返回首页
     *
     * @return
     */
    @RequestMapping(value = "back", method = RequestMethod.GET)
    public String goBack() {
        if ("登录".equals("")) {
            return "index";
        } else {
            return "login";
        }
    }

    /**
     *
     * yui eiu yty tye
     * yui eiu ytyi uty
     * yui eiu yty tye
     * yui opu ytyi uty

     * io p}pi o  |  uy te opi
     * yui opu  yuii iop
     * io p}pi o | uyte opi
     * yui opu yty
     *
     *
     * E  W  Q  J    H   G  H  J
     * A  B   N  C   V    B  V  B

     3   2   1   U  Y   T   Y   U
     T  T   E   E  Q   Q  Q   W
     A  B   N  C   V   A  V   B
     */
}
