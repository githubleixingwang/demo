package com.appleyk.DMB15_观察者模式.DM15.Spring事件机制解耦业务.service;

import com.appleyk.DMB15_观察者模式.DM15.Spring事件机制解耦业务.dao.UserDao;
import com.appleyk.DMB15_观察者模式.DM15.Spring事件机制解耦业务.event.DeleteUserEvent;
import com.appleyk.DMB15_观察者模式.DM15.Spring事件机制解耦业务.event.SaveUserEvent;
import com.appleyk.DMB15_观察者模式.DM15.Spring事件机制解耦业务.model.TUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 13:26 2021/2/21
 */
@Service
public class UserService implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    private ApplicationContext context;

    public void register(TUser user) throws Exception {
        long start = System.currentTimeMillis();
        userDao.save(user);
//        为了保证发送邮件一定是在用户注册成功后才进行，可以使用下面的方式，让事务提交成功了，在发布事件
//        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
//            @Override
//            public void afterCompletion(int status) {
//                try {
//                    context.publishEvent(new TSendEmailEvent(this,user.getEmail(),
//                            "恭喜你成功注册XXX系统会员，更多内容请登录官网进行查看"));
//                } catch (Exception e) {
//                    logger.info("错误信息：{}",e.getMessage());
//                }
//            }
//        });
//    }
        System.out.println("新增用户");

        // 注册完，发布事件（只需调用一次，就将可能比较耗时、比较复杂的发送邮件的业务与当前的service进行了解耦）
        context.publishEvent(new SaveUserEvent(this, user.getUserName(),user.getEmail()));//在这发布了事件，由哪个监听执行，取决于发布的事件、监听的事件一致
    }
    public void deleteUser(TUser user) throws Exception {
        System.out.println("删除用户");
        // 注册完，发布事件（只需调用一次，就将可能比较耗时、比较复杂的发送邮件的业务与当前的service进行了解耦）
        context.publishEvent(new DeleteUserEvent(this, user.getUserName(),user.getEmail()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
