package com.zsx.web.config;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZSX on 2018/1/24.
 *
 * @author ZSX
 */
//@Configuration
//@ComponentScan(basePackages = "com.zsx.web.service")
//@EnableCaching(proxyTargetClass = true)
public class GuavaCacheConfig implements CachingConfigurer {

    // 无法把cache加到cacheManager里
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        GuavaCache cache = new GuavaCache("cacheName",
                CacheBuilder.newBuilder()
                        .recordStats()
                        .maximumSize(1000)
                        .expireAfterWrite(1, TimeUnit.DAYS)
                        .build());

        cacheManager.setCaches(Lists.newArrayList(cache));
        Collection<String> cacheNames = cacheManager.getCacheNames();
        // TODO: 2018/1/24 获取为[]
        System.out.println(JSON.toJSONString(cacheNames));
        return cacheManager;
    }

    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }
}
