package com.zsz.music.service.impl;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.zsz.music.mapper.CollectMapper;
import com.zsz.music.po.Collect;
import com.zsz.music.service.CollectService;
import com.zsz.music.vo.SongView;

@Transactional
public class CollectServiceImpl implements CollectService {
	@Autowired
    private CollectMapper collectionsDao;
	@Override
	public void addCollection(Collect collection) {
		collectionsDao.add(collection);
	}
	@Override
	public void delete(int cid) {
		collectionsDao.delete(cid);

	}

	@Override
	public List<SongView> getMyCollectionList(int uid,int pc,int ps) {
		return collectionsDao.getMyCollectionsList(uid, pc, ps);
	}

	@Override
	public int getMyCollectionspages(int uid, int ps) {
		int records=collectionsDao.getMyTotalCollectionRecords(uid);
		int pages=records%ps==0?records/ps:records/ps+1;
		return pages==0?1:pages;
	}
	public static void main(String[] args) {
		int length=UUID.randomUUID().toString().length();
		System.out.println(UUID.randomUUID().toString());
		System.out.println(length);
	}
}
