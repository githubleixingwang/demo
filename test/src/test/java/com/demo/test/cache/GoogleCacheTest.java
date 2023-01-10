package com.demo.test.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GoogleCacheTest {

    @Autowired
    private GoogleCache googleCache;

    @Test
    public void putCache() {
        googleCache.putCache("a","a");
    }

    @Test
    public void getCache() {
        googleCache.putCache("a","a");

        googleCache.getCache("a");
    }
}