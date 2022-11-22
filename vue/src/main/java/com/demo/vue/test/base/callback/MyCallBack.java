package com.demo.vue.test.base.callback;

public interface MyCallBack {

    void callBack();

   default  String def(){
        return "ss";
    }
    default  String def2(){
        return "ss2";
    }
}
