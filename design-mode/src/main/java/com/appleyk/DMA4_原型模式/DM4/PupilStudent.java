package com.appleyk.DMA4_原型模式.DM4;

import java.io.Serializable;

/**
 * <p>小学生 == 如果要实现对象的深度拷贝，嵌套引用类型的对象类必须也实现Serializable接口</p>
 *
 * @author Appleyk
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 1:14 2018-11-8
 * @version v0.1.1
 */
public class PupilStudent implements Serializable {
    
	private static final long serialVersionUID = 1L;

	/**学号*/
    private Long sNo;

    /**年级*/
    private Integer sClass;

    /**姓名*/
    private String name;

    /**年龄*/
    private Integer age;

    /**性别*/
    private ESexType sex = ESexType.MALE;

    public  PupilStudent(){}

    public Long getsNo() {
        return sNo;
    }

    public void setsNo(Long sNo) {
        this.sNo = sNo;
    }

    public Integer getsClass() {
        return sClass;
    }

    public void setsClass(Integer sClass) {
        this.sClass = sClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ESexType getSex() {
        return sex;
    }

    public void setSex(ESexType sex) {
        this.sex = sex;
    }
}
