package com.demo.moudleOne.todo.java;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/wrapper")
@RestController
public class RequestWrapperTest {

    @PostMapping("/test1")
    public String  test(Vo vo){
        String a = vo.getA();
        String b = vo.getB();
        String c = vo.getC();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        return  a;
    }
    @PostMapping("/test2")
    public void test( String a,String b,String c){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    //requestWrapper不能进行参数过滤
    @PostMapping("/test3")
    public void test( @RequestBody Map<String,String> map ){
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
    }
    @PostMapping("/test4")
    public void test( HttpServletRequest request ){
        System.out.println(request.getParameter("a"));
        System.out.println(request.getParameter("b"));
        System.out.println(request.getParameter("c"));
    }
}
