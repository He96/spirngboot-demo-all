package com.config;

import com.alibaba.fastjson.JSON;
import com.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录信息
 */
@Component
public class LoginContext {

    @Autowired
    private RedisService redisService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    /**
     * 设置cookie
     *
     * @param key    cookie名字
     * @param value  cookie值
     * @param maxAge cookie生命周期  以秒为单位
     */
    public void setAuthCookie(String key, String value, int maxAge) {
        CookieHelper.addCookie(response, "token", key, maxAge);
        redisService.setex(ConfigUtil.productName + ":OnlineUsers:" + key, 86400, value);
    }


    public boolean isAuthorized() {
        Cookie cookie = CookieHelper.getCookieByName(request, "token");
        if (cookie != null) {
            String key = cookie.getValue();
            boolean result = redisService.exists(ConfigUtil.productName + ":OnlineUsers:" + key);
            return result;
        }
        return false;
    }

    public void signOut() {
        Cookie cookie = CookieHelper.getCookieByName(request, "token");
        if (cookie != null) {
            String key = cookie.getValue();
            redisService.del(ConfigUtil.productName + ":OnlineUsers:" + key);
            CookieHelper.removeCookie(request, response, "token");
        }
    }

    public String getValue() {
        Cookie cookie = CookieHelper.getCookieByName(request, "token");
        if (cookie != null) {
            String key = cookie.getValue();
            String json = redisService.get(ConfigUtil.productName + ":OnlineUsers:" + key);
            return json;
        }
        return null;
    }

    public void setValue(String value) {
        Cookie cookie = CookieHelper.getCookieByName(request, "token");
        if (cookie != null) {
            String key = cookie.getValue();
            redisService.setex(ConfigUtil.productName + ":OnlineUsers:" + key, 86400, value);

        }
    }

    public LoginInfo getInfo() {
        LoginInfo info = JSON.parseObject(getValue(), LoginInfo.class);
        return info;
    }
}
