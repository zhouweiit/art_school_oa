package com.chengzi.art.school.oa.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.Duration;

/**
 * Created by zhouwei on 2018/12/24
 **/
//@Configuration
public class RedisConfig {

    @Value("${spring.redis.default.host}")
    private String defaultHost;

    @Value("${spring.redis.default.port}")
    private Integer defaultPort;

    @Bean(name = "defaultJedisConnectionFactory")
    public JedisConnectionFactory defaultJedisConnectionFactory() {
        // 设置基本信息
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(defaultHost);
        redisStandaloneConfiguration.setPort(defaultPort);

        // 设置连接池
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(10);
        genericObjectPoolConfig.setMaxIdle(5);
        genericObjectPoolConfig.setMinIdle(5);
        genericObjectPoolConfig.setTestOnBorrow(true);
        genericObjectPoolConfig.setTestOnReturn(true);
        genericObjectPoolConfig.setTestWhileIdle(true);
        genericObjectPoolConfig.setTestOnCreate(true);
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder()
                .connectTimeout(Duration.ofSeconds(30L))
                .readTimeout(Duration.ofSeconds(30L))
                .usePooling()
                .poolConfig(genericObjectPoolConfig)
                .build();

        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
        return factory;
    }

    @Bean(name = "defaultRedisTemplate")
    public StringRedisTemplate defaultRedisTemplate(@Autowired @Qualifier("defaultJedisConnectionFactory") RedisConnectionFactory factory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

}
