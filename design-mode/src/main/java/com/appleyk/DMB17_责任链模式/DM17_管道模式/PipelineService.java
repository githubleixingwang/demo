package com.appleyk.DMB17_责任链模式.DM17_管道模式;

import com.appleyk.DMB17_责任链模式.DM17_管道模式.config.PipelineExecutor;
import com.appleyk.DMB17_责任链模式.DM17_管道模式.data.InstanceBuildContext;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author: lxw
 * @date: 2024-02-05  16:17
 */
@Service
@Slf4j
public class PipelineService {

    @Resource
    private PipelineExecutor pipelineExecutor;

    public void pipelineTest() {
        InstanceBuildContext data = new InstanceBuildContext();
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("instanceName","test");
        data.setFormInput(map);

        boolean success = pipelineExecutor.acceptSync(data);

        // 创建模型实例成功
        if (success) {
            System.out.println("成功");
            return;
        }

        log.error("创建模式实例失败：{}", data.getErrorMsg());
        System.out.println(data.getErrorMsg());
    }

}
