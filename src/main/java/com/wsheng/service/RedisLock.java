package com.wsheng.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Redis是单线程的
 * @Auther: wsheng
 * @Date: 2018/11/19 22:38
 * @Description:
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private  StringRedisTemplate redisTemplate;

    /**ReadWriteLock
     * 加锁
     * @param key
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key,String value){

        if (redisTemplate.opsForValue().setIfAbsent(key,value)) {
            //说明已经被锁定了
            return true;
        }
        String currentValue = redisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(currentValue) &&
                Long.parseLong(currentValue) < System.currentTimeMillis()){
            //获取上一个锁的是时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key,value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key ,String value){
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue)&& currentValue.equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("【Redis分布式锁】 解锁异常, {}",e);
        }
    }
}
