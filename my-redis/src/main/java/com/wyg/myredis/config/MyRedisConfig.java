package com.wyg.myredis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory) {
        // 使用<String, Object>
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // json序列化配置
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(mapper);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        // String的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用string的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key采用string的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }

    @Bean
    RedisCacheManager userCacheManager(RedisConnectionFactory factory) {
        // 初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(factory);
        // 设置CacheManager的值序列化方式为json序列化
        RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
                .fromSerializer(jsonSerializer);
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair);
        // 设置默认超时过期时间是30秒
        cacheConfiguration.entryTtl(Duration.ofSeconds(30));
        // 初始化RedisCacheManager
        return new RedisCacheManager(redisCacheWriter, cacheConfiguration);
    }
}
