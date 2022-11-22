package com.demo.moudleOne.todo.java;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class SqlValidatorUtil {
    public SqlValidatorUtil() {
    }

    public static boolean sqlValidator(HttpServletRequest request, String badStr) {
        //获得所有请求参数名
        Enumeration params = request.getParameterNames();
        String sql = "";
        while (params.hasMoreElements()) {
            String name = params.nextElement().toString();
            String[] value = request.getParameterValues(name);
            for (int i = 0; i < value.length; ++i) {
                sql = sql + value[i];
            }

        }
        return sqlValidator(request, badStr);
    }

    public static boolean validator(String str, String badStr) {
        str = str.toLowerCase();
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; ++i) {
            if (str.indexOf(badStrs[i]) != -1) {
                return true;
            }
        }
        return false;
    }
}


