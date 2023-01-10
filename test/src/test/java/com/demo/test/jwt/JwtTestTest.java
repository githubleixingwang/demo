package com.demo.test.jwt;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class JwtTestTest {
    @Autowired
    private JwtTest jwtTest;

    @Test

    public void test() {
        String token = jwtTest.sign("aa", "bb");
        boolean verify = jwtTest.verify(token);
        boolean jwtExpired = jwtTest.isJwtExpired(token);

    }
}