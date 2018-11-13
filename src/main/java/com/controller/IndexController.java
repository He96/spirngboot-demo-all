package com.controller;

import com.config.LoginContext;
import com.config.LoginInfo;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    LoginContext loginContext;

    /**
     * 访问首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexPage(Model model) {
        LoginInfo info = loginContext.getInfo();
        if (info != null && !"".equals(info.getAccount())) {
            User user = new User();
            BeanUtils.copyProperties(info, user);
            model.addAttribute("userInfo", user);
            return "index";
        } else {
            model.addAttribute("info", "登录信息已过期，请重新登录");
            return "redirect:login";
        }
    }

    /**
     * 获取用户信息
     *
     * @param user 查询条件
     */
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String userList(User user, Model model) {
        if (user == null) {
            user = new User();
        }
        List<User> list = userService.getList(user);
        model.addAttribute("userList", list);
        return "user";
    }

    /**
     * 跳转私聊模式
     */
    @RequestMapping(value = "chatOne", method = RequestMethod.GET)
    public String chartOne(Model model) {
        LoginInfo info = loginContext.getInfo();
        if (info != null && info.getId() > 0) {
            model.addAttribute("userInfo", info);
            User user = new User();
            user.setNotId(info.getId());
            List<User> list = userService.getList(user);
            model.addAttribute("userList", list);
            return "chatOne";
        }
        return "redirect:login";
    }

    @RequestMapping(value = "chatAll", method = RequestMethod.GET)
    public String chartAll(Model model) {
        LoginInfo info = loginContext.getInfo();
        if (info != null && info.getId() > 0) {
            model.addAttribute("userInfo", info);
            User user = new User();
            user.setNotId(info.getId());
            List<User> list = userService.getList(user);
            model.addAttribute("userList", list);
            return "chatAll";
        }
        return "redirect:login";
    }
}
