package com.demo.common.mapper;

import com.demo.common.entity.SgDeviceFiles;
import com.demo.common.entity.SgDeviceFilesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SgDeviceFilesMapper {
    long countByExample(SgDeviceFilesExample example);

    int deleteByExample(SgDeviceFilesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SgDeviceFiles record);

    int insertSelective(SgDeviceFiles record);

    List<SgDeviceFiles> selectByExample(SgDeviceFilesExample example);

    SgDeviceFiles selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SgDeviceFiles record, @Param("example") SgDeviceFilesExample example);

    int updateByExample(@Param("record") SgDeviceFiles record, @Param("example") SgDeviceFilesExample example);

    int updateByPrimaryKeySelective(SgDeviceFiles record);

    int updateByPrimaryKey(SgDeviceFiles record);
}