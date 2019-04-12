package com.zsx.web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zsx.web.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
	
    int deleteByPrimaryKey(@Param(value="id")String id);

    int insert(User user);

    User selectByPrimaryKey(@Param(value="id")String id);

    List<User> selectAll();
	
}