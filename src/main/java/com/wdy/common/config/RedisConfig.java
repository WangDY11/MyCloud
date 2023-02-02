package com.wdy.common.config;

/**
 * @desc Redis配置
 * @date 2019/6/6
 * @author wjy
 */
//@Configuration
public class RedisConfig {
//
//    @Autowired
//    private PropertiesUtil propertiesUtil;
//
//    JedisPool jedisPool;
//
//    @PostConstruct
//    public void getJedisPool() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(propertiesUtil.getProperty("spring.redis.jedis.pool.max-idle", Integer.class));
//        jedisPoolConfig.setMaxTotal(propertiesUtil.getProperty("spring.redis.jedis.pool.max-active", Integer.class));
//        jedisPoolConfig.setMaxWaitMillis(propertiesUtil.getProperty("spring.redis.jedis.pool.max-wait", Integer.class));
//        jedisPoolConfig.setTestOnBorrow(propertiesUtil.getProperty("spring.redis.jedis.pool.testOnBorrow", Boolean.class));
//        jedisPoolConfig.setTestOnReturn(propertiesUtil.getProperty("spring.redis.jedis.pool.testOnReturn", Boolean.class));
//        jedisPool = new JedisPool(jedisPoolConfig,
//                propertiesUtil.getProperty("spring.redis.host", String.class),
//                propertiesUtil.getProperty("spring.redis.port", Integer.class),
//                propertiesUtil.getProperty("spring.redis.timeout", Integer.class),
//                propertiesUtil.getProperty("spring.redis.password", String.class),
//                propertiesUtil.getProperty("spring.redis.database", Integer.class));
//    }
//
//    public Jedis getJedis() {
//        Jedis jedis = jedisPool.getResource();
//        return jedis;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(name = "redisTemplate")
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
//        redisTemplate.setEnableTransactionSupport(true);
//        redisTemplate.setConnectionFactory(factory);
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer =
//                new Jackson2JsonRedisSerializer<Object>(Object.class);
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(name = "stringRedisTemplate")
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setEnableTransactionSupport(true);
//        stringRedisTemplate.setConnectionFactory(factory);
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        stringRedisTemplate.setKeySerializer(stringRedisSerializer);
//        stringRedisTemplate.setHashKeySerializer(stringRedisSerializer);
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer =
//                new Jackson2JsonRedisSerializer<Object>(Object.class);
//        stringRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        stringRedisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        stringRedisTemplate.afterPropertiesSet();
//        return stringRedisTemplate;
//    }

}
