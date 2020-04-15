package com.zsz.music.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zsz.music.po.Song;
import com.zsz.music.vo.SongView;
public interface SongMapper {
 public void add(Song add);
 public void delete(int songId);
 public Song getMySongById(int songId);
 public void updateMysong(Song song);
 public List<Song> getMySongList(@Param("uid")int uid,@Param("begin")int begin,@Param("ps")int ps);
 public List<SongView> getAllSongList(@Param("begin")int begin,@Param("ps")int ps);
 public int getMyTotalRecords(int uid);
 public int getAllTotalRecords();
}
