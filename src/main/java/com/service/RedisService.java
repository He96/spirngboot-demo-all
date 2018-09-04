package com.service;

import redis.clients.jedis.Jedis;

public interface RedisService {

   /* Jedis getResource();

    void close(Jedis jedis);*/

    /**
     * 根据键获取值
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 删除键
     * @param key
     */
    void del(String key);

    /**
     * 设置值
     * @param key 键
     * @param time 过期时间(小于等于0则不会过期)
     * @param value 值
     * @return
     */
    String setex(String key,int time,String value);

    /**
     * 查看该键是否存在
     * @param key 键
     * @return
     */
    boolean exists(String key);
}
