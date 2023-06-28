package com.appleyk.DMB15_观察者模式.DM15.Spring事件机制解耦业务.listener;

import com.appleyk.DMB15_观察者模式.DM15.Spring事件机制解耦业务.event.DeleteUserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * <p>删除用户监听器</p>
 *
 * @author appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 13:38 2021/2/21
 */
@Component
public class DeleteUserListener {

    @Async("taskExecutor") // 标注异步执行
    @EventListener //事件监听
    @Order(0) //控制同一事件的监听顺序
    public void sendEmail(DeleteUserEvent event) {
        // 只要TSendEmailEvent发生（发布），这里就会去调用邮件事件的send方法，给用户发送邮件
            System.out.println("删除用户的异步线程 = " + Thread.currentThread().getName());
            System.out.println("========== 正在给用户发送删除邮件，请稍等.....==========");
        System.out.printf("给用户<%s>的邮箱<%s>发送邮件成功！\n", event.getUserName(), event.getEmail());
    }

}
