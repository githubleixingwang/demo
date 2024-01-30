package com.demo.jar.vo;

import lombok.Data;

/**
 * @author: lxw
 * @date: 2024-01-25  10:26
 */
@Data
public class Ticket12306Vo {
    private String phone;//账号
    private String psw;//密码
    private String idCard;//身份证后四位
    private String start;//出发地
    private String end;//目的地
    private String travelTtime;//时间
    private String trainNumber;//车次
    private String passenger;//乘车人
    private String seats;//坐席
}
