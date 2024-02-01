package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vipss;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.Map;

/**
 * 工厂抽象：抽取多个简单工厂中共同部分，子工厂加载时才会触发抽象工厂中的bean初始化
 *
 * @author: lxw
 * @date: 2024-01-31  17:11
 */

public  class StrategyVipssFactory<T, S extends StrategyVipss<T>> implements InitializingBean, ApplicationContextAware {

    private final Class<S> strategyType;

    /**
     * 所有策略-工厂对应关系
     */
    private Map<T, S> strategyMap;

    private ApplicationContext appContext;

    /**
     * 创建一个策略工厂
     *
     * @param strategyType 策略的类型
     */
    public StrategyVipssFactory(Class<S> strategyType) {
        this.strategyType = strategyType;
    }

    /**
     * 根据策略 id 获得对应的策略的 Bean
     *
     * @param id 策略 id
     * @return 策略的 Bean
     */
    public S getStrategyById(T id) {
        return strategyMap.get(id);
    }


    /**
     * 子类实例化完成后加载
     */
    @Override
    public void afterPropertiesSet() {
        // 获取 Spring 容器中，所有 S 类型的 Bean
        Collection<S> strategies = appContext.getBeansOfType(strategyType).values();

        strategyMap = Maps.newHashMapWithExpectedSize(strategies.size());

        // 将所有 S 类型的 Bean 放入到 strategyMap 中
        for (final S strategy : strategies) {
            T id = strategy.getId();
            strategyMap.put(id, strategy);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }
}
