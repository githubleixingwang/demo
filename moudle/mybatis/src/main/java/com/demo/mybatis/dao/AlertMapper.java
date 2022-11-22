package com.demo.mybatis.dao;

import com.demo.mybatis.domain.Alert;
import com.demo.mybatis.domain.AlertExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlertMapper {
    long countByExample(AlertExample example);

    int deleteByExample(AlertExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Alert record);

    int insertSelective(Alert record);

    List<Alert> selectByExample(AlertExample example);

    Alert selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Alert record, @Param("example") AlertExample example);

    int updateByExample(@Param("record") Alert record, @Param("example") AlertExample example);

    int updateByPrimaryKeySelective(Alert record);

    int updateByPrimaryKey(Alert record);

    int count();
    List<Alert> select();
}