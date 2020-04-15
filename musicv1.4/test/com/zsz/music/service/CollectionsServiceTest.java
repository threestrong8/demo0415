package com.zsz.music.service;

import org.junit.Before;
import org.junit.Test;

import com.zsz.music.po.Collect;
import com.zsz.music.service.impl.CollectServiceImpl;
public class CollectionsServiceTest {
    private CollectService service;
	@Before
	public void setUp() throws Exception {
		service=new CollectServiceImpl();
	}

	@Test
	public void addCollectionTest() {
		Collect collection=new Collect();
		collection.setSongId(1);
		collection.setUserId(2);
		service.addCollection(collection);
	}
	@Test
	public void deleteTest() {
		service.delete(4);
	}
	@Test
	public void getMyCollectionListTest() {
		System.out.println(service.getMyCollectionList(1, 1,10));
	}
	@Test
	public void getMyCollectionspagesTest() {
		System.out.println(service.getMyCollectionspages(1, 2));
	}

}
