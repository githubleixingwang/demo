package com.demo.test.util.rsa;

import lombok.Data;

@Data
public class A {
    private String a;
    private String b;
    private B c;

    @Data
    public static class B{
        private String c;
    }
}
