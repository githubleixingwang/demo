package com.demo.vue.test.string;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StringRange {

    public  void test1() {
        String a =null;
        String s = String.valueOf(a);
        boolean n = s.startsWith("n");
        boolean empty = a.isEmpty();
        System.out.println(s+n+empty);
    }

    public  void test2() {
        List<Long> groupIds = new ArrayList<>();
        groupIds.add(1l);
        groupIds.add(2l);
        List<String> ids = groupIds.stream().map(x-> "ll"+x+"ll").collect(Collectors.toList());
        String idStrs =  StringUtils.join(ids,",");
        //将collection类型集合转为string类型，以，分隔
        String s =  StringUtils.join(groupIds,",");
        System.out.println(idStrs);
        System.out.println("in("+s+")");
        System.out.println("a,b,c");
    }


}
