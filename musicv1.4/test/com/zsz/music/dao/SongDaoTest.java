package com.zsz.music.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import com.zsz.music.mapper.SongMapper;
import com.zsz.music.po.Song;

public class SongDaoTest {
	 private SongMapper dao;
	   private SqlSession session;
		@Before
		public void setUp() throws Exception {
			SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
			 session=fac.openSession(true);
			dao=session.getMapper(SongMapper.class);
		}
	@Test
	public void addTest() {
		Song song=new Song();
		song.setUserId(1);
		song.setSongName("认真的雪");
		song.setSinger("薛之谦");
		dao.add(song);
	}
	@Test
	public void deleteTest() {
		dao.delete(104);
	}

	@Test
	public void updateMysongTest() {
		Song song=new Song();
		song.setId(103);
		song.setSongName("认真的");
		song.setSinger("薛之谦");
		dao.updateMysong(song);
	}

	@Test
	public void  getMySongListTest() {
		System.out.println(dao.getMySongList(1, 2, 2));
	}

	@Test
	public void getAllSongListTest() {
		System.out.println(dao.getAllSongList(2, 2));
	}

	@Test
	public void getMyTotalRecordsTest() {
		System.out.println(dao.getMyTotalRecords(1));
	}

	@Test
	public void  getAllTotalRecordsTest() {
		System.out.println(dao.getAllTotalRecords());
	}

	@Test
	public void getMySongByIdTest() {
		System.out.println(dao.getMySongById(103));
	}

}
