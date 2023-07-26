package com.demo.jar.factory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author: lxw
 * @date: 2023-07-26  14:49
 */
@Configuration
@Slf4j
public class ThreadPoolFactory {


    /**
     * 有界线程池：线程池最大可执行线程=最大线程数参数+有界队列的长度。
     *
     * @return
     */
    @Bean(name = "threadPoolExecutor")
    public ThreadPoolExecutor threadPoolExecutor() {
        /*workQueue：一个阻塞队列，用来存储线程池等待执行的任务，均为线程安全。它一般分为直接提交队列、有界任务队列、无界任务队列、优先任务队列几种，包含以下 7 种类型：
        ArrayBlockingQueue：一个由数组结构组成的有界阻塞队列。
        LinkedBlockingQueue：一个由链表结构组成的有界阻塞队列。
        SynchronousQueue：一个不存储元素的阻塞队列，即直接提交给线程不保持它们，最大线程数=最大线程数+0。

        PriorityBlockingQueue：一个支持优先级排序的无界阻塞队列。
        DelayQueue：一个使用优先级队列实现的无界阻塞队列，只有在延迟期满时才能从中提取元素
        LinkedTransferQueue：一个由链表结构组成的无界阻塞队列。与SynchronousQueue类似，还含有非阻塞方法。
        LinkedBlockingDeque：一个由链表结构组成的双向阻塞队列。
        较常用的是 LinkedBlockingQueue 和 Synchronous，线程池的排队策略与 BlockingQueue 有关。*/
        ThreadPoolExecutor threadPoolTaskExecutor = new ThreadPoolExecutor(
                5,//核心线程数
                10,//最大线程数
                10,//除核心外的线程未使用时存活时间
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(90),//有界阻塞队列，长度90，此线程池最多可开启100个线程处理100个并发（最大线程数+队列的长度），超过后命中拒绝策略
                new ThreadFactoryBuilder().setNameFormat("general-detail-batch-%d").build(),//线程工厂，此处对线程设置了前缀
                new ThreadPoolExecutor.AbortPolicy());//拒绝策略； 默认是抛异常
        return threadPoolTaskExecutor;
    }

    /**
     * 无界线程池：线程池最大可执行线程=无限，无线线程时由数量为核心线程数的线程一直执行，最大线程数参数失效
     *
     * @return
     */
    @Bean(name = "threadPoolExecutor2")
    public ThreadPoolExecutor threadPoolExecutor2() {
        ThreadPoolExecutor threadPoolTaskExecutor = new ThreadPoolExecutor(
                5,
                10,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                new ThreadFactoryBuilder().setNameFormat("general-detail-batch-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());//拒绝策略； 默认是抛异常
        return threadPoolTaskExecutor;
    }
}
