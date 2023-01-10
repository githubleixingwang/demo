package com.demo.test.base64;

import java.util.ArrayList;
import java.util.Base64;

/**
 * @author: lxw
 * @date: 2022-12-22  16:44
 */
public class Test {
    public static void main(String[] args) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            Base64.Encoder encoder = Base64.getEncoder();
            ArrayList<String> s = new ArrayList<>();
            s.add("a");
            s.add("b");
            byte[] textByte = ObjUtils.obj2byte(s);
            //编码
            final String encodedText = encoder.encodeToString(textByte);
            System.out.println(encodedText);
            //解码
            byte[] decode = decoder.decode(encodedText);
            Object obj = ObjUtils.byte2obj(decode);
            System.out.println(obj + ":" + obj.getClass().toString());
        } catch (Exception e) {
        }


    }
}
