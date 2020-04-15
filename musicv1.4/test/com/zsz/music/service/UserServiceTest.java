package com.zsz.music.service;

import org.junit.Before;
import org.junit.Test;
import com.zsz.music.po.User;
import com.zsz.music.service.impl.UserServiceImpl;

public class UserServiceTest {
    private UserService service;
	@Before
	public void setUp() throws Exception {
		service=new UserServiceImpl();
	}

	@Test
	public void addTest() {
		User user=new User();
		user.setUserName("小三");
		user.setPwd("123");
		service.add(user);
	}
	@Test
	public void getTest() {
		System.out.println(service.getUser("14450", "123"));
	}
}
