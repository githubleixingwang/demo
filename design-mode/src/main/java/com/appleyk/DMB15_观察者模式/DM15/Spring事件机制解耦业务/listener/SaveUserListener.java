package com.appleyk.DMB15_观察者模式.DM15.Spring事件机制解耦业务.listener;

import com.appleyk.DMB15_观察者模式.DM15.Spring事件机制解耦业务.event.SaveUserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * <p>新增用户监听器</p>
 *
 * @author appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 13:38 2021/2/21
 */
@Component
public class SaveUserListener {

    @Async("taskExecutor") // 标注异步执行
    @EventListener //事件监听
    @Order(0) //控制同一事件的监听顺序
    public void sendEmail(SaveUserEvent event) {
        // 只要TSendEmailEvent发生（发布），这里就会去调用邮件事件的send方法，给用户发送邮件
            System.out.println("新增用户的异步异步 = " + Thread.currentThread().getName());
            System.out.println("========== 正在给用户发送新增邮件，请稍等.....==========");
        System.out.printf("给用户<%s>的邮箱<%s>发送邮件成功！\n", event.getUserName(), event.getEmail());
    }

}
