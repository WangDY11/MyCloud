package com.wdy.common.util;





/**
 * @desc Redis工具类
 * @date 2019/6/6
 * @author wjy
 */
//@Component
public class RedisUtil {

//    @Autowired
//    private RedisTemplate<Object, Object> redisTemplate;
//
//    /*
//     * common
//     */
//
//    /**
//     * 根据keys删除缓存
//     *
//     * @param keys
//     * @return
//     */
//    public void delete(Object... keys) {
//        redisTemplate.delete(Arrays.asList(keys));
//    }
//
//    /**
//     * 根据key获取缓存失效时间
//     *
//     * @param key
//     * @return
//     */
//    public long getExpire(Object key) {
//        Long l = redisTemplate.getExpire(key, TimeUnit.SECONDS);
//        return l;
//    }
//
//    /**
//     * 设置缓存失效时间
//     *
//     * @param key
//     * @param timeout
//     * @return
//     */
//    public void expire(Object key, long timeout) {
//        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
//    }
//
//    /*
//     * string
//     */
//
//    /**
//     * 放入缓存并且设置失效时间
//     *
//     * @param key
//     * @param value
//     * @param timeout
//     * @return 不存在 true 存在 false
//     */
//    public Boolean setIfAbsent(Object key, Object value, long timeout) {
//        Boolean b = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.SECONDS);
//        return b;
//    }
//
//    /**
//     * 放入缓存并且设置失效时间
//     *
//     * @param key
//     * @param value
//     * @param timeout
//     * @return
//     */
//    public void setValue(Object key, Object value, long timeout) {
//        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
//    }
//
//    /**
//     * 放入缓存
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public void setValue(Object key, Object value) {
//        redisTemplate.opsForValue().set(key, value);
//    }
//
//    /**
//     * 根据key获取缓存
//     *
//     * @param key
//     * @return
//     */
//    public Object getValue(Object key) {
//        Object value = redisTemplate.opsForValue().get(key);
//        return value;
//    }
//
//    /*
//     * list
//     */
//
//    /**
//     * 推送缓存
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public void leftPushList(Object key, Object value) {
//        redisTemplate.opsForList().leftPush(key, value);
//    }
//
//    /**
//     * 弹出缓存
//     *
//     * @param key
//     * @return
//     */
//    public Object rightPopList(Object key) {
//        Object value = redisTemplate.opsForList().rightPop(key);
//        return value;
//    }
//
//    /*
//     * set
//     */
//
//    /**
//     * @desc 添加set
//     * @date 2019/6/14
//     * @author wjy
//     */
//    public void addSet(Object key, Object... values) {
//        redisTemplate.opsForSet().add(key, values);
//    }
//
//    /**
//     * @desc 移除set
//     * @date 2019/6/14
//     * @author wjy
//     */
//    public void removeSet(Object key, Object... values) {
//        redisTemplate.opsForSet().remove(key, values);
//    }
//
//    /*
//     * zset
//     */
//
//    /**
//     * 添加缓存
//     *
//     * @param key
//     * @param member
//     * @param score
//     * @return
//     */
//    public void addZSet(Object key, Object member, double score) {
//        redisTemplate.opsForZSet().add(key, member, score);
//    }
//
//    /**
//     * 根据key和member移除缓存
//     *
//     * @param key
//     * @param member
//     * @return
//     */
//    public Long removeZSet(Object key, Object member) {
//        Long l = redisTemplate.opsForZSet().remove(key, member);
//        return l;
//    }
//
//    /**
//     * @desc 根据key和行范围获取member和score
//     * @date 2019/6/10
//     * @author wjy
//     */
//    public Set<ZSetOperations.TypedTuple<Object>> rangeWithScoresZSet(Object key, long l1, long l2) {
//        Set<ZSetOperations.TypedTuple<Object>> set = redisTemplate.opsForZSet().rangeWithScores(key, l1, l2);
//        return set;
//    }

}
