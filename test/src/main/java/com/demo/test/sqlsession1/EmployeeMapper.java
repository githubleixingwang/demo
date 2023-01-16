package com.demo.test.sqlsession1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: lxw
 * @date: 2023-01-16  11:27
 */

@Mapper
public interface EmployeeMapper {

    public void delete(String name) ;

    public Integer saveBatch(List<EmployeeDO> list) ;
}
