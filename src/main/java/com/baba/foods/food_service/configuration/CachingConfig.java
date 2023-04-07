package com.baba.foods.food_service.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class CachingConfig {
    @Value("${redis.timeout.auto-complete-minutes}")
    private Long autocomplete;

    @Value("${redis.timeout.location-minutes}")
    private Long location;
    @Bean
    RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        log.info("Log::CachingConfig redisCacheManagerBuilderCustomizer()");
        return (builder) -> {
            Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
            configurationMap
                    .put("location", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofSeconds(location))
                            .disableCachingNullValues()
                    );
            configurationMap
                    .put("autocomplete", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofSeconds(autocomplete))
                            .disableCachingNullValues()
                    );

            builder.withInitialCacheConfigurations(configurationMap);
        };
    }
}
