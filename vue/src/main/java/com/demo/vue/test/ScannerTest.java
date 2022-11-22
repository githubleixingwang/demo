package com.demo.vue.test;
import java.util.Date;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        StringBuilder stringBuilder = new StringBuilder(next);
        System.out.println("输入信息反向输出：" + stringBuilder.reverse());
    }
}
