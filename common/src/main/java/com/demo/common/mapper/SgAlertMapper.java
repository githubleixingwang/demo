package com.demo.common.mapper;

import com.demo.common.entity.SgAlert;
import com.demo.common.entity.SgAlertExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SgAlertMapper {
    long countByExample(SgAlertExample example);

    int deleteByExample(SgAlertExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SgAlert record);

    int insertSelective(SgAlert record);

    List<SgAlert> selectByExample(SgAlertExample example);

    SgAlert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SgAlert record, @Param("example") SgAlertExample example);

    int updateByExample(@Param("record") SgAlert record, @Param("example") SgAlertExample example);

    int updateByPrimaryKeySelective(SgAlert record);

    int updateByPrimaryKey(SgAlert record);
}