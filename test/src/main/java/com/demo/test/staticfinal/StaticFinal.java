package com.demo.test.staticfinal;

import java.util.Random;

/**
 * @author: lxw
 * @date: 2023-01-11  15:44
 */
public class StaticFinal {

    private static Random rand = new Random(50);
    private static int a = rand.nextInt(10);
    private final int b = rand.nextInt(10);
    private static final int c = rand.nextInt(10);

    public static void main(String[] args) {
        StaticFinal sf = new StaticFinal();
        System.out.println("sf : " + "a=" + sf.a );
        System.out.println("sf : " + "B=" + sf.b );
        System.out.println("sf : " + "B=" + sf.c );

        System.out.println("------------------------------");
        StaticFinal sf1 = new StaticFinal();
        System.out.println("sf1 : " + "a=" + sf1.a);
        System.out.println("sf1 : " + "B=" + sf1.b );
        System.out.println("sf1 : " + "B=" + sf1.c );

    }
}
