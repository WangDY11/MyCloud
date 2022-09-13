package com.vilsale.common.util;

import com.vilsale.common.config.RedisConfig;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * @author syz
 */
@Component
public class JedisUtil {

    @Resource
    private RedisConfig redisConfig;

    public Boolean setnx(String k, String v, int expire) {
        Jedis jedis = redisConfig.getJedis();
        Long r = jedis.setnx(k, v);
        if (expire > 0) {
            jedis.expire(k, expire);
        }
        jedis.close();
        return r == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    public Boolean setString(String k, String v, int expire) {
        Jedis jedis = redisConfig.getJedis();
        String r = jedis.set(k, v);
        if (expire > 0) {
            jedis.expire(k, expire);
        }
        jedis.close();
        return r.equals("OK") ? Boolean.TRUE : Boolean.FALSE;
    }

    public Boolean setString(String k, String v) {
        Jedis jedis = redisConfig.getJedis();
        String r = jedis.set(k, v);
        jedis.close();
        return r.equals("OK") ? Boolean.TRUE : Boolean.FALSE;
    }

    public String getString(String k) {
        Jedis jedis = redisConfig.getJedis();
        String r = jedis.get(k);
        jedis.close();
        return r;
    }

    //删除String类型key对应的值
    public Boolean sdel(String key) {
        Jedis jedis = redisConfig.getJedis();
        Long r = jedis.del(key);
        jedis.close();
        return r == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    //判断redis中是否存在某个键
    public Boolean exist(String k) {
        Jedis jedis = redisConfig.getJedis();
        Boolean exists = jedis.exists(k);
        jedis.close();
        return exists;
    }

    //为哈希表中的字段赋值
    public Boolean hset(String key, String field, String value) {
        Jedis jedis = redisConfig.getJedis();
        Long r = jedis.hset(key, field, value);
        jedis.close();
        return r == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    //获取哈希表中key集合
    public Set<String> hkeys(String key) {
        Jedis jedis = redisConfig.getJedis();
        Set<String> hkeys = jedis.keys(key);
        jedis.close();
        return hkeys;
    }

    //获取哈希表的fieid字段的值
    public String hget(String key, String field) {
        Jedis jedis = redisConfig.getJedis();
        String hget = jedis.hget(key, field);
        jedis.close();
        return hget;
    }

    //取出哈希表中key对应的全部值
    public Map<String, String> hgetAll(String key) {
        Jedis jedis = redisConfig.getJedis();
        Map<String, String> map = jedis.hgetAll(key);
        jedis.close();
        return map;
    }

    public Boolean hdel(String key,String field) {
        Jedis jedis = redisConfig.getJedis();
        Long r = jedis.hdel(key, field);
        jedis.close();
        return r == 1 ? Boolean.TRUE : Boolean.FALSE;
    }
}
