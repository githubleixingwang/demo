package com.demo.common.mapper;

import com.demo.common.entity.BugInfo;
import com.demo.common.entity.BugInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface BugInfoMapper {
    long countByExample(BugInfoExample example);

    int deleteByExample(BugInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BugInfo record);

    int insertSelective(BugInfo record);

    List<BugInfo> selectByExample(BugInfoExample example);

    BugInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BugInfo record, @Param("example") BugInfoExample example);

    int updateByExample(@Param("record") BugInfo record, @Param("example") BugInfoExample example);

    int updateByPrimaryKeySelective(BugInfo record);

    int updateByPrimaryKey(BugInfo record);
}