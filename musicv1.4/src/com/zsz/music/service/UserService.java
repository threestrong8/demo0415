package com.zsz.music.service;

import com.zsz.music.po.User;

public interface UserService {
  public void add(User user);
  public User getUser(String emial,String pwd);
}
