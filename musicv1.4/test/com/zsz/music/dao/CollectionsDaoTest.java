package com.zsz.music.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import com.zsz.music.mapper.CollectMapper;
import com.zsz.music.po.Collect;
public class CollectionsDaoTest {
	  private CollectMapper dao;
	   private SqlSession session;
		@Before
		public void setUp() throws Exception {
			SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
			 session=fac.openSession(true);
			dao=session.getMapper(CollectMapper.class);
		}

	@Test
	public void getMyTotalCollectionRecordsTest() {
		  System.out.println(dao.getMyTotalCollectionRecords(1));
	}
	@Test
	public void getMyCollectionsListTest() {
	     System.out.println(dao.getMyCollectionsList(1, 0, 3));
	}
	@Test
	public void deleteTest() {
		dao.delete(12);
	}
	@Test
	public void addTest() {
		Collect collect=new Collect();
		collect.setSongId(103);
		collect.setUserId(1);
		dao.add(collect);
	}
	@Test
	public void deleteallTest() {
		dao.deleteBySongId(103);
	}
}
