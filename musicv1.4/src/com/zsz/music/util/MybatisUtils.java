package com.zsz.music.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
    public static SqlSessionFactory factory;
    static{
    	  try {
			factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public static SqlSessionFactory getSqlSessionFactory(){
    	return factory;
    }
    public static SqlSession getSession(){
    	return factory.openSession(true);
    }
}
