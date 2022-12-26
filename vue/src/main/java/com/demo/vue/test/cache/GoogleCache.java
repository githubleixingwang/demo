package com.demo.vue.test.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

@Component
public class GoogleCache {
    Cache<Object, Object> cache = CacheBuilder.newBuilder().build();

    public void putCache(String a ,String b){
        cache.put(a,b);

    }
    public void getCache(String a ){
        System.out.println(cache.getIfPresent(a));

    }
}
