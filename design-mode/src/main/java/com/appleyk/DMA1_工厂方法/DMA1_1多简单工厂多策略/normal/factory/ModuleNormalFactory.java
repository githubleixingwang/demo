package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.normal.factory;

import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.normal.handler.ModuleNormal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lxw
 * @date: 2024-01-31  16:28
 */
@Component
public class ModuleNormalFactory {

    private static final Map<String, ModuleNormal> map = new HashMap<>(16);


    public ModuleNormal getModule(String moduleName) {
        return map.get(moduleName);
    }

    @Autowired
    public void setConverters(List<ModuleNormal> moduleNormals) {
        for (final ModuleNormal moduleNormal : moduleNormals) {
            map.put(moduleNormal.getModule(), moduleNormal);
        }
    }
}