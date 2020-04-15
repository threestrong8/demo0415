package com.zsz.music.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zsz.music.po.Collect;
import com.zsz.music.vo.SongView;
public interface CollectMapper {
  public void delete(int collectionId);
  public void deleteBySongId(int SongId);
  public  List<SongView> getMyCollectionsList(@Param("uid")int uid,@Param("begin")int begin,@Param("ps")int ps);
  public int getMyTotalCollectionRecords(int uid);
  public void add(Collect collection);
}
