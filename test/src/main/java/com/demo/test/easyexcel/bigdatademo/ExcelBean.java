package com.demo.test.easyexcel.bigdatademo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: lxw
 * @date: 2023-06-01  10:36
 */
@Accessors(chain = true)
@Data
public class ExcelBean {
    @ExcelProperty("主键id")
    private String id;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("地址")
    private String address;
    @ExcelProperty("年龄")
    private Integer age;
    @ExcelProperty("数量")
    private Integer number;
    @NumberFormat("#.##")
    @ExcelProperty("身高")
    private Double high;
    @ExcelProperty("距离")
    private Double distance;
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @ExcelProperty("开始时间")
    private Date startTime;
    @ExcelProperty("结束时间")
    private Date endTime;
}

