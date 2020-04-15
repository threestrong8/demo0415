package com.zsz.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.zsz.music.mapper.UserMapper;
import com.zsz.music.po.User;
import com.zsz.music.service.UserService;
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
   private UserMapper userDao;
	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public User getUser(String email, String pwd) {
		return userDao.getUser(email, pwd);
	}

}
