package com.demo.test.schedule;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author: lxw
 * @date: 2023-01-12  16:04
 */
@Component
@Data
public class MySchedule implements SchedulingConfigurer {

   /*第一种方式页面传参
   private String cron;

    private Long timer = 10000L;*/

    private static ScheduledTaskRegistrar scheduledTaskRegistrar;
    public static Map<String, TriggerTask> triggerTaskMap = new HashMap<>();

    @Override
    public void configureTasks(ScheduledTaskRegistrar registrar) {
        scheduledTaskRegistrar = registrar;
        //第二种方式从数据库中查询出所有定时任务，模拟
        List<Cron> list = new ArrayList<>();
        for (Cron cron : list) {
            TriggerTask triggerTask = new TriggerTask(getRunnable(cron), getTrigger(cron));
            scheduledTaskRegistrar.addTriggerTask(triggerTask);
            triggerTaskMap.put(cron.getId(), triggerTask);
        }
    }

    private static Runnable getRunnable(Cron cron) {
        return new Runnable() {
            @Override
            public void run() {
                Class<?> clazz;
                try {
                    clazz = Class.forName(cron.getClassName());
                    Object bean = BeansUtils.getBean(clazz);
                    Method method = ReflectionUtils.findMethod(bean.getClass(), cron.getMethodName());
                    ReflectionUtils.invokeMethod(method, bean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static Trigger getTrigger(Cron cron) {
        return new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger trigger = new CronTrigger(cron.getCronExpression());
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
               /*     //使用CronTrigger触发器，可动态修改cron表达式来操作循环规则
                    CronTrigger cronTrigger = new CronTrigger(cron);
                    Date nextExecutionTime = cronTrigger.nextExecutionTime(triggerContext);

                    // 使用不同的触发器，为设置循环时间的关键，区别于CronTrigger触发器，该触发器可随意设置循环间隔时间，单位为毫秒
                    PeriodicTrigger periodicTrigger = new PeriodicTrigger(timer);
                    Date nextExecutionTime = periodicTrigger.nextExecutionTime(triggerContext);
                    return nextExecutionTime;*/
            }
        };
    }

    /**
     * 单次执行
     *
     * @param id
     * @return
     */
    public static boolean run(String id) {
        TriggerTask tt = triggerTaskMap.get(id);
        if (tt != null) {
            //只执行一次
            tt.getRunnable().run();
            return true;
        }
        return false;
    }

    /**
     * 停止
     *
     * @param id
     * @return
     */
    public static boolean stop(String id) {
        TriggerTask tt = triggerTaskMap.get(id);
        if (tt != null) {
            Set<ScheduledTask> scheduledTasks = scheduledTaskRegistrar.getScheduledTasks();
            for (ScheduledTask st : scheduledTasks) {
                boolean b = st.getTask().getRunnable() == tt.getRunnable();
                if (b) {
                    st.cancel();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 启动
     *
     * @param cron
     * @return
     * @throws Exception
     */
    public static boolean start(Cron cron) throws Exception {
        try {
            triggerTaskMap.remove(cron.getId());
            TriggerTask tt = new TriggerTask(getRunnable(cron), getTrigger(cron));
            triggerTaskMap.put(cron.getId(), tt);
            scheduledTaskRegistrar.scheduleTriggerTask(tt);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
