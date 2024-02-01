package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略.vips;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/**
 * 工厂抽象：抽取多个简单工厂中共同部分，子工厂加载时才会触发抽象工厂中的bean初始化
 *
 * @author: lxw
 * @date: 2024-01-31  17:11
 */
public abstract class StrategyVipsFactory<T, S extends StrategyVips<T>> implements InitializingBean, ApplicationContextAware {


    /**
     * 所有策略-工厂对应关系
     */
    private Map<T, S> strategyMap;

    private ApplicationContext appContext;

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
     * 利用反射实现
     *
     * @return 策略的类型
     */
    protected  Class<S> getStrategyType(){
        // getClass 获取当前运行时实例的类，getGenericSuperclass 获得泛型父类
        //getGenericSuperclass使用条件，实例类有超类，并且超类有泛型信息
        Type superclass = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) superclass;
        Type[] actualTypeArguments = pt.getActualTypeArguments();
        // 获得索引为 1 的实际参数类型，即第二个实际参数的类型
        Type actualTypeArgument = actualTypeArguments[1];
        @SuppressWarnings("unchecked")
        Class<S> result = (Class<S>) actualTypeArgument;
        return result;
    };

    /**
     * 子类实例化完成后加载
     */
    @Override
    public void afterPropertiesSet() {
        // 获取 Spring 容器中，所有 S 类型的 Bean
        Collection<S> strategies = appContext.getBeansOfType(getStrategyType()).values();

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
