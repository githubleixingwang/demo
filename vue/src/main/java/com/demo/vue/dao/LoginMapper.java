package com.demo.vue.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    Boolean verUserInfo(@Param("userName") String userName, @Param("pad") String pad);
}
