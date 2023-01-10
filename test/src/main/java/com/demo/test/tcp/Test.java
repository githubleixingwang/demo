package com.demo.test.tcp;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author: lxw
 * @date: 2022-06-27  16:21
 */
public class Test {
    public static void main(String[] args) {
//        Pattern pat = Pattern.compile("C(.*?)[1]");
//        String s = "C:/asf dfa df122";
//        Matcher matcher = pat.matcher(s);
//        if(matcher.find())
//        {
//            String valueWrapper = matcher.group(1).trim();
//            System.out.println(valueWrapper);
//        }
        Map<Object, Object> map = new HashMap<>();
       map.put("a","a");
        System.out.println(map.toString());

        /*int a =50;
        long b =1000 * 60 * 60 * 24;
        System.out.println(1000 * 60 * 60 * 24);
        System.out.println(a*b);
        System.out.println(((long)a*1000) * 60 * 60 * 24);

        long realTime = System.currentTimeMillis() + a * 1000 * 60 * 60 * 24;*/

        Map<Integer, testEnum> map1 = testEnum.map;

        testEnum system = testEnum.valueOf("SYSTEM");
        System.out.println(EnumUtils.isValidEnum(testEnum.class, "system"));

        int max=1;
        System.out.println(++max);
        System.out.println(++max);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(0);
        System.out.println(list.contains(1));

        String ruleExpression ="(107&&110)||(108||109)";
        ruleExpression = ruleExpression.replaceAll("[^-?0-9]+", ",");
        List<Long> longs = new ArrayList<>();
        String[] split = ruleExpression.trim().split(",");
        Arrays.stream(split).filter(e->StringUtils.isNotBlank(e)).forEach(e->{
                longs.add(Long.valueOf(e));
            });
        longs.stream().forEach(a -> System.out.println(a));

        Object entity ="1";
        System.out.println(entity.getClass() != Long.TYPE && entity.getClass() != Integer.TYPE && entity.getClass() != Long.class && entity.getClass() != Integer.class);


        System.out.println(list.stream().map(a -> a + 10).collect(Collectors.toList()));
        System.out.println(list.stream().map(a -> {
            return a + 10;
        }).collect(Collectors.toList()));


        ArrayList<A> as = new ArrayList<>();
        A a = new A();
        a.setA("a");
        a.setB("b");
         as.add(a);
       String first = as.stream().filter(e -> "b".equals(e.getB())).map(b -> Optional.ofNullable(b.getB()).orElse("")).findFirst().orElse("sssss");
        //String aa = first.isPresent() ? first.get() : "";
        System.out.println(first);


        String str = "3";
        String pattern = "^((?![0-9]+).)*$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }

     static class A{
        private String a;
        private String b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }


    public enum testEnum {
        SYSTEM(0,"aa"),
        CUSTOM(1,"bb");

        private int code;
        private String key;
        private static Map<Integer, testEnum> map = new HashMap<>();

        testEnum(int code, String key) {
            this.code = code;
            this.key = key;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public static String getName(Integer code) {
            testEnum orgSourceEnum = map.get(code);
            return orgSourceEnum.getKey();
        }

        static {
            for (testEnum value : values()) {
                map.put(value.getCode(), value);
            }
        }
    }

}
