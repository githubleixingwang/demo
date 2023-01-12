package com.demo.test.schedule;

import lombok.Data;

/**
 * @author: lxw
 * @date: 2023-01-12  16:21
 */

@Data
public class Cron {
    private String id;
    private String jobStatus; //状态
    private String cronExpression; //表达式
    private String className; //类名
    private String methodName; //方法名

}
