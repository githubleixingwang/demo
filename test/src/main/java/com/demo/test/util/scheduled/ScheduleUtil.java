package com.demo.test.util.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.Task;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

/**
 * @author: lxw
 * @date: 2023-03-07  17:30
 */
@Component
public class ScheduleUtil {

    /**
     * BeanPostProcessor 用于终止定时任务
     */
    @Autowired
    private ScheduledAnnotationBeanPostProcessor postProcessor;

    /**
     * 根据 methodName 终止定时任务
     *
     * @param methodName
     */
    public void cancelScheduledTask(String methodName) {
        Set<ScheduledTask> tasks = postProcessor.getScheduledTasks();

        // 在所有定时任务中找出 methodName 并取消掉
        tasks.stream().forEach(task -> {
            Task t = task.getTask();
            ScheduledMethodRunnable runnable = (ScheduledMethodRunnable) t.getRunnable();
            if (Objects.equals(runnable.getMethod().getName(), methodName)) {
                // 调用postProcessBeforeDestruction()方法取消task
                postProcessor.postProcessBeforeDestruction(runnable.getTarget(), methodName);
            }
        });
    }
}

