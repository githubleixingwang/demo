package com.demo.jar.controller;

import com.demo.jar.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池总结：
 * 1. 自定义线程池，能有效避免线程堆积
 * 2. 自定义线程池时要注意合理设置参数，根据业务选择有限队列还是无限队列
 * 有界线程池：线程池最大可执行线程=最大线程数参数的值+有界队列的长度。当业务的线程数超过该值时，超过部分的线程会触发拒绝策略。 正在执行的线程数量不能超过最大线程参数的值
 * 无界线程池：线程池最大可执行线程=无限，无线线程时由数量为核心线程数的线程一直执行，最大线程数参数失效。  正在执行的线程数量等于核心线程数量
 * 3. 线程池执行完业务后会保留核心线程，如果要彻底关闭线程池不在使用可以使用shutdown()
 * 4. 局部线程池（在方法中声明的线程池），请务必务必要手动关闭，即调用shutdown()。
 *
 * @author: lxw
 * @date: 2023-07-26  16:00
 */
@RestController
public class TestController {

    @Resource
    public TestService testService;
    @Resource
    private ThreadPoolExecutor threadPoolExecutor;//有界线程池
    @Resource
    private ThreadPoolExecutor threadPoolExecutor2;//无界线程池

    @RequestMapping("/testa")
    public void testa() {
        /*testService.a()标注了异步并使用了自定义的线程池，此时用for循环算是并发操作；
        若testService.a()未标注异步，也就未使用线程池，那就是普通的方法调用，按顺序执行不算并发*/
        for (int i = 0; i < 100; i++) {
            testService.a(i);
            if (i == 0) {
                System.out.println("先输出代表异步执行");
            }
        }
        //threadPoolExecutor.shutdown();
    }

    @RequestMapping("/testb")
    public void testB() {
        for (int i = 0; i < 1100; i++) {
            testService.b(i);
        }
    }

    @RequestMapping("/testc")
    public void testC() {
        while (true){

        }
    }

}
