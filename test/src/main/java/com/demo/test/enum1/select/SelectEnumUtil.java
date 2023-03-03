package com.demo.test.enum1.select;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lxw
 * @date: 2023-02-24  16:40
 */
public class SelectEnumUtil {


    /**
     * 获取下拉框数据
     * @param enumCode
     * @return
     */
    public static SelectEnumVo getEnumByCode(String enumCode) {
        SelectEnumVo selectEnumVo = new SelectEnumVo();
        SelectEnumListEnum element = SelectEnumListEnum.getByCode(enumCode);
        List<Map<String, String>> options = new ArrayList<>();

        try {
            Class<Enum> enumDemo = (Class<Enum>) Class.forName(element.getPath());//获取枚举类对象
            Method nameMethod = enumDemo.getMethod("getValue");
            Method codeMethod = enumDemo.getMethod("getCode");
            Enum[] elements = enumDemo.getEnumConstants();//获取枚举的元素数组
            for (Enum e : elements) {
                Map<String, String> map = new HashMap<>();
                map.put((String) codeMethod.invoke(e), (String) nameMethod.invoke(e));
                options.add(map);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        selectEnumVo.setCode(enumCode);
        selectEnumVo.setName(element.getName());
        selectEnumVo.setDesc(element.getDesc());
        selectEnumVo.setOptions(options);
        return selectEnumVo;
    }

}
