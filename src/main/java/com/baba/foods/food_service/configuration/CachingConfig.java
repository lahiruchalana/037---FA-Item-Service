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

    @Value("${redis.timeout.locationTime}")
    private Long location;

    @Value("${redis.timeout.foodTime}")
    private Long food;

    @Bean
    RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        log.info("Log::CachingConfig redisCacheManagerBuilderCustomizer()");
        return (builder) -> {
            Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
            configurationMap
                    .put("location", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofMinutes(location))
                            .disableCachingNullValues()
                    );
            configurationMap
                    .put("autocomplete", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofMinutes(autocomplete))
                            .disableCachingNullValues()
                    );
            configurationMap
                    .put("food", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofMinutes(food))
                            .disableCachingNullValues()
                    );

            builder.withInitialCacheConfigurations(configurationMap);
        };
    }
}
