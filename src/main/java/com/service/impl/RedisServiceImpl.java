package com.service.impl;

import com.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean set(String key, Object value) {
        boolean result = false;
        try{
            ValueOperations<Serializable,Object> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存设置有效时间
     * @param key
     * @param value
     * @param time
     * @return
     */
    @Override
    public boolean set(String key, Object value, Long time) {
        boolean result = false;
        try{
            ValueOperations<Serializable,Object> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key,value);
            redisTemplate.expire(key,time,TimeUnit.SECONDS);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量删除对应的值
     * @param keys
     */
    @Override
    public void remove(String... keys) {
        for (String key : keys){
            remove(key);
        }
    }

    /**
     * 批量删除key
     * @param pattern
     */
    @Override
    public void removePattern(String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if(keys.size()>0){
            redisTemplate.delete(keys);
        }
    }

    /**
     * 删除对应的值
     * @param key
     */
    @Override
    public void remove(String key) {
        if(hasKey(key)){
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断是否有key
     * @param key
     * @return
     */
    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    @Override
    public Object get(String key) {
        ValueOperations<Serializable,Object> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    /**
     * 哈希添加
     * @param key
     * @param hashKey
     * @param value
     */
    @Override
    public void hashSet(String key, Object hashKey, Object value) {
        HashOperations<String,Object,Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key,hashKey,value);
    }


    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    @Override
    public Object hashGet(String key, Object hashKey) {
        HashOperations<String,Object,Object> hashOperations = redisTemplate.opsForHash();
        return hashOperations.get(key,hashKey);
    }

    /**
     * 列表的添加
     * @param key
     * @param value
     */
    @Override
    public void lPush(String key, Object value) {
        ListOperations<String,Object> listOperations = redisTemplate.opsForList();
        listOperations.rightPush(key,value);
    }

    /**
     * 列表的获取
     * @param key
     * @param x
     * @param y
     * @return
     */
    @Override
    public List<Object> lRange(String key, long x, long y) {
        ListOperations<String,Object> listOperations = redisTemplate.opsForList();
        return listOperations.range(key,x,y);
    }

    /**
     * 集合的添加
     * @param key
     * @param value
     */
    @Override
    public void add(String key, Object value) {
        SetOperations<String,Object> setOperations = redisTemplate.opsForSet();
        setOperations.add(key,value);
    }

    /**
     * 集合的获取
     * @param key
     * @return
     */
    @Override
    public Set<Object> getSet(String key) {
        SetOperations<String,Object> setOperations = redisTemplate.opsForSet();
        return setOperations.members(key);
    }


    /**
     * 有序集合的添加
     * @param key
     * @param value
     * @param source
     */
    @Override
    public void sortAdd(String key, Object value, double source) {
        ZSetOperations<String,Object> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(key,value,source);
    }

    /**
     * 有序集合的获取
     * @param key
     * @param source
     * @param value
     * @return
     */
    @Override
    public Set<Object> getSort(String key, double source, double value) {
        ZSetOperations<String,Object> zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.rangeByScore(key,source,value);
    }
}
