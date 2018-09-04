package com.controller;

import com.service.RedisService;
import com.util.AllowPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * redis 单机操作测试类
 */
@RestController
@RequestMapping("redis/")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @AllowPass
    @RequestMapping("{id}")
    public Object get(@PathVariable("id") String key) {
        Object result = null;
        if (key != null && !"".equals(key)) {
            result = redisService.get(key);
        }
        return result;
    }

    @AllowPass
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Object set(@RequestBody Map<String, Object> map) {
        Object result = null;
        if (map != null && map.containsKey("key")) {
            result = redisService.setex(map.get("key").toString(), 0, map.get("value").toString());
        }
        return result;
    }

    @AllowPass
    @RequestMapping("remove/{id}")
    public String del(@PathVariable("id") String key) {
        boolean result = false;
        if (key != null && !"".equals(key)) {
           redisService.del(key);
           return "删除成功";
        }
        return "键不存在，删除失败！";
    }


}
