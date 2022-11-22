package com.demo.vue.dao;

import com.demo.common.entity.BugInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BugMapper {

    List<BugInfo> queryList();

}
