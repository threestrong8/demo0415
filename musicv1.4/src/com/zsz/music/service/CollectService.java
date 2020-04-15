package com.zsz.music.service;

import java.util.List;

import com.zsz.music.po.Collect;
import com.zsz.music.vo.SongView;

public interface CollectService {
   public void addCollection(Collect collection);
   public void delete(int cid);
   public List<SongView> getMyCollectionList(int uid,int pc,int ps);
   public int getMyCollectionspages(int uid,int ps);
}
