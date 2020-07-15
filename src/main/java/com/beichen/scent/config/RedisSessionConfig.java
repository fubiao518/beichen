package com.beichen.scent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @ClassName RedisSessionConfig
 * @Description
 * @Author fubiao
 * @Date 2020/7/3 10:33
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1600)
public class RedisSessionConfig {
}
