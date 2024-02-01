package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.normal.factory;

import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.normal.handler.FormItemNormal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lxw
 * @date: 2024-01-31  16:27
 */
@Component
public class FormItemNormalFactory {

    private static final Map<String, FormItemNormal> map = new HashMap<>(16);

    /**
     * 通过标识获取对应处理类
     *
     * @param name
     * @return
     */
    public FormItemNormal getFormItem(String name) {
        return map.get(name);
    }

    @Autowired
    public void setFormDataHandlers(List<FormItemNormal> formItemNormals) {
        for (FormItemNormal formItem : formItemNormals) {
            map.put(formItem.getName(), formItem);
        }
    }
}