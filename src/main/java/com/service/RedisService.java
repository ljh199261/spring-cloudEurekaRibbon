package com.service;
import java.util.List;
import java.util.Set;

public interface RedisService {
    public boolean set(final String key, Object value);
    public boolean set(final String key, Object value, Long time);
    public void remove(final String... keys);
    public void removePattern(final String pattern);
    public void remove(final String key);
    public boolean hasKey(final String key);
    public Object get(final String key);
    public void hashSet(String key, Object hashKey, Object value);
    public Object hashGet(String key, Object hashKey);
    public void lPush(String key, Object value);
    public List<Object> lRange(String key, long x, long y);
    public void add(String key, Object value);
    public Set<Object> getSet(String key);
    public void sortAdd(String key, Object value, double source);
    public Set<Object> getSort(String key, double source, double value);
}
