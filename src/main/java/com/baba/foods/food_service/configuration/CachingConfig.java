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

    @Value("${redis.timeout.foodTime}")
    private Long food;

    @Value("${redis.timeout.cookingMethodTime}")
    private Long cookingMethod;

    @Value("${redis.timeout.courseTime}")
    private Long course;

    @Value("${redis.timeout.cuisineTypeTime}")
    private Long cuisineType;

    @Value("${redis.timeout.measuringTypeTime}")
    private Long measuringType;

    @Value("${redis.timeout.nutritionInformationTime}")
    private Long nutritionInformation;

    @Value("${redis.timeout.themeTime}")
    private Long theme;

    @Bean
    RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        log.info("Log::CachingConfig redisCacheManagerBuilderCustomizer()");
        return (builder) -> {
            Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
            configurationMap
                    .put("food", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofMinutes(food))
                            .disableCachingNullValues()
                    );
            configurationMap
                    .put("cookingMethod", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofMinutes(cookingMethod))
                            .disableCachingNullValues()
                    );
            configurationMap
                    .put("course", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofMinutes(course))
                            .disableCachingNullValues()
                    );
            configurationMap
                    .put("cuisineType", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofMinutes(cuisineType))
                            .disableCachingNullValues()
                    );

            configurationMap
                    .put("measuringType", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofMinutes(measuringType))
                            .disableCachingNullValues()
                    );
            configurationMap
                    .put("nutritionInformation", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofMinutes(nutritionInformation))
                            .disableCachingNullValues()
                    );
            configurationMap
                    .put("theme", RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofMinutes(theme))
                            .disableCachingNullValues()
                    );


            builder.withInitialCacheConfigurations(configurationMap);
        };
    }
}
