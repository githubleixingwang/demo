package com.demo.test.callback;

public interface MyCallBack {

    void callBack();

   default  String def(){
        return "ss";
    }
    default  String def2(){
        return "ss2";
    }
}
