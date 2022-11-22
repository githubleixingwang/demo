package com.demo.vue.aa;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Macther {

    public static void main(String[] args) {
        String s = "dd-erew-h";
        String[] split = s.split("-", 2);
        System.out.println(split[0].matches("\\d{4}"));


        ArrayList<String> mtypes = new ArrayList<>();
        mtypes.add("a");
        mtypes.add("b");
        mtypes.add("c");
        String conditionStr = "";
        for(int i = 0 ; i < mtypes.size(); i++){
            String mtype = mtypes.get(i);
            conditionStr += "'" + mtype + "'";
            if((i + 1) != mtypes.size()){
                conditionStr += ",";
            }
        }
        System.out.println(conditionStr);

        String[] arr = new String[mtypes.size()];
        Arrays.fill(arr,"a");
    }
}
