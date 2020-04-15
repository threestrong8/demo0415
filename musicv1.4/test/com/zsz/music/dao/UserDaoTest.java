package com.zsz.music.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import com.zsz.music.mapper.UserMapper;
import com.zsz.music.po.User;

public class UserDaoTest {
   private UserMapper dao;
   private SqlSession session;
	@Before
	public void setUp() throws Exception {
		SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
		 session=fac.openSession(true);
		dao=session.getMapper(UserMapper.class);
	}

	@Test
	public void addTest() {
		User user=new User();
		user.setEmail("14450");
		user.setUserName("小红");
		user.setPwd("123");
		dao.add(user);
	}
	@Test
	public void getTest() {
		System.out.println(dao.getUser("14450", "123"));
	}

}
