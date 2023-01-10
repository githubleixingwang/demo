package com.demo.test.ratelimit.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;

/**
 * @author: lxw
 * @date: 2023-01-10  11:19
 */
@Service
public class LoadingCacheService {

    //Guava缓存
    public static LoadingCache<String, RateLimiter> ipRequestCaches = CacheBuilder.newBuilder()
            .maximumSize(1000)// 设置缓存最大个数,当Cache中的记录数量达到最大值后再调用put方法向其中添加对象，Guava会先从当前缓存的对象记录中选择一条删除掉，腾出空间后再将新的对象存储到Cache中
            .expireAfterWrite(1, TimeUnit.MINUTES)//当缓存项在指定的时间段内没有更新就会被回收
            .build(new CacheLoader<String, RateLimiter>() {
                @Override
                public RateLimiter load(String s) throws Exception {
                    //缓存中不存在key，设置默认值放到缓存中
                    return RateLimiter.create(0.1);// 新的IP初始化 (限流每秒0.1个令牌响应,即10s一个令牌)
                }
            });

    /**
     * 控制每秒N个许可(不限制IP)
     *
     * @return
     */
    public boolean tryAcquire() {
        RateLimiter rateLimiter = RateLimiter.create(10.0);
        return rateLimiter.tryAcquire();

    }

    /**
     * 控制每个IP的每秒N个许可(限制IP访问接口频率)
     *
     * @param ipAddr ip地址
     * @return 控制每个IP的每秒N个许可(限制IP访问接口频率)
     * @throws ExecutionException
     */
    public RateLimiter getIPLimiter(String ipAddr) throws ExecutionException {
        return ipRequestCaches.get(ipAddr);
    }


}
