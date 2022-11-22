package com.demo.vue.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BugVo {

    private String bugTag;

    private String ascrProject;

    private String principal;

    private String bugLevel;

//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //返回时间类型
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") //接收时间类型
    private Date endTime;

    private String bugState;

    private String bugConfirm;

    private String bugDesc;

    private String bugDescUrl;

    private String bugSolvePlan;

    private String bugSolvePlanUrl;


}
