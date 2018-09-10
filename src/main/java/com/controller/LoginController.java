package com.controller;

import com.alibaba.fastjson.JSON;
import com.entity.User;
import com.service.UserService;
import com.util.AllowPass;
import com.util.Result;
import com.config.LoginContext;
import com.config.LoginInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

//用户登陆
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    LoginContext loginContext;

    /**
     * 登录
     *
     * @param data
     * @return
     */
    @AllowPass
    @RequestMapping(value = "loginInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object loginInfo(@RequestBody User data) {
        if (data != null && StringUtils.isNotEmpty(data.getAccount()) &&
                StringUtils.isNotEmpty(data.getPassword())) {
            User user = userService.login(data);
            if (user != null) {
                LoginInfo loginInfo = new LoginInfo();
                BeanUtils.copyProperties(user, loginInfo);
                String token = UUID.randomUUID().toString().replaceAll("-", "");
                loginContext.setAuthCookie(token, JSON.toJSONString(loginInfo), 0);
                return new Result(1, "登录成功!");
            }
        }
        return new Result(-1, "用户名或密码有误!");
    }

    /**
     * 退出登录
     *
     * @return 1：成功 0：失败
     */
    @RequestMapping(value = "sign/out", method = RequestMethod.GET)
    @ResponseBody
    public Result signOut() {
        try {
            loginContext.signOut();
            return new Result(1, "退出成功！");
        } catch (Exception ex) {
            return new Result(0, "退出失败！");
        }
    }

    @AllowPass
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexPage(Model model) {
        LoginInfo info = loginContext.getInfo();
        if (info != null && !"".equals(info.getAccount())) {
            User user = new User();
            BeanUtils.copyProperties(info,user);
            model.addAttribute("userInfo", user);
            return "index";
        } else {
            model.addAttribute("info", "登录信息已过期，请重新登录");
            return "redirect:login";
        }
    }
}
