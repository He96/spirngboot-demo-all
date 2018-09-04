package com.service.impl;

import com.service.RedisService;
import com.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisUtils redisUtils;

    private static Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

   /* @Autowired
    private JedisPool jedisPool;

    @Override
    public Jedis getResource() {
        return jedisPool.getResource();
    }

    @Override
    public void close(Jedis jedis) {
        if (jedis != null) {
            jedisPool.close();
            if (jedis.isConnected()) {
                try {
                    jedis.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    @Override
    public String get(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = redisUtils.getJedis();
            value = jedis.get(key);
            logger.info("redis get success - " + key + ",value:" + value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("redis get error:" + e.getMessage() + " - " + key
                    + ",value:" + value);
        }finally {
            redisUtils.close(jedis);
        }
        return value;
    }

    @Override
    public void del(String key) {
        Jedis jedis = null;
        try {
            jedis = redisUtils.getJedis();
            jedis.del(key);
            logger.info("redis del success - " + key);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("redis del error - " + key + " ,msg:" + e.getMessage());
        }finally {
            redisUtils.close(jedis);
        }
    }

    @Override
    public String setex(String key, int time, String value) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = redisUtils.getJedis();
            if (time <= 0) {
                result = jedis.set(key, value);
            } else {
                result = jedis.setex(key, time, value);
            }
            logger.info("redis set success - " + key + " ,value:" + value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("redis set error -" + key + " ,msg:" + e.getMessage());
        }finally {
            redisUtils.close(jedis);
        }
        return result;
    }

    @Override
    public boolean exists(String key) {
        Jedis jedis = null;
        boolean flag = false;
        try {
            jedis = redisUtils.getJedis();
            flag = jedis.exists(key);
            logger.info("redis success key:" + key + "is exists! return:" + flag);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("redis error key:" + key + ",Exception:" + e.getMessage());
        }finally {
            redisUtils.close(jedis);
        }
        return flag;
    }
}
