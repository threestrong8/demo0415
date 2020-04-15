package com.zsz.music.mapper;

import org.apache.ibatis.annotations.Param;

import com.zsz.music.po.User;

public interface UserMapper {
  public void add(User user);
  public User getUser(@Param("email")String email,@Param("pwd")String pwd);
}
