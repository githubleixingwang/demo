package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略;

import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.normal.factory.FormItemNormalFactory;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.normal.factory.ModuleNormalFactory;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.normal.handler.FormItemNormal;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.normal.handler.ModuleNormal;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.factory.FormItemVipFactory;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.factory.ModuleVipFactory;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.handler.FormItemVip;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vip.handler.ModuleVip;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips.factory.FormItemVipsFactory;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips.factory.ModuleVipsFactory;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips.handler.FormItemVips;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips.handler.ModuleVips;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vipss.StrategyVipssFactory;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vipss.handler.FormItemVipss;
import com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vipss.handler.ModuleVipss;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: lxw
 * @date: 2024-01-31  16:47
 */
@Service
public class RunService {
    @Resource
    private FormItemNormalFactory formItemNormalFactory;
    @Resource
    private ModuleNormalFactory moduleNormalFactory;
    @Resource
    private FormItemVipFactory formItemVipFactory;

    @Resource
    private ModuleVipFactory moduleVipFactory;

    @Resource
    private FormItemVipsFactory formItemVipsFactory;

    @Resource
    private ModuleVipsFactory moduleVipsFactory;
    @Resource(name = "formItemVipssFactory")
    private StrategyVipssFactory formItemVipssFactory;

    @Resource(name = "moduleVipssFactory")
    private StrategyVipssFactory moduleVipssFactory;

    public void testNormal() {
        //a工厂->处理类->业务
        FormItemNormal formItem = formItemNormalFactory.getFormItem("input");
        System.out.println(formItem.handler());

        //b工厂->处理类->业务
        ModuleNormal module = moduleNormalFactory.getModule("firstModule");
        System.out.println(module.handler());
        //n个工厂...
    }

    public void testVip() {
        FormItemVip input = formItemVipFactory.getStrategyById("inputVip");
        System.out.println(input.handler());
        ModuleVip first = moduleVipFactory.getStrategyById("firstVip");
        System.out.println(first.handler());
    }

    public void testVips() {
        FormItemVips input = formItemVipsFactory.getStrategyById("inputVips");
        System.out.println(input.handler());
        ModuleVips first = moduleVipsFactory.getStrategyById("firstVips");
        System.out.println(first.handler());
    }

    public void testVipss() {
        FormItemVipss input = (FormItemVipss) formItemVipssFactory.getStrategyById("inputVipss");
        System.out.println(input.handler());
        ModuleVipss first = (ModuleVipss) moduleVipssFactory.getStrategyById("firstVipss");
        System.out.println(first.handler());
    }
}
