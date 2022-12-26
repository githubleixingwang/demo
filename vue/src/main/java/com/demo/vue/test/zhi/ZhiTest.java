package com.demo.vue.test.zhi;

import java.util.ArrayList;
import java.util.List;

public class ZhiTest {
    public void zhi(){
//        A a = new A();
//        a.setName("a");
//        change(a);
//        System.out.println("原 :" + a.getName());
        List<String> a = null;
        a=change(a);
        System.out.println("change :" + a.size());


    }

    public List<String> change(List<String> a){
      a=new ArrayList<String>();
      a.add("1");
        System.out.println("change :" + a.size());
        return a ;
    }

     class A{
        String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }
}
