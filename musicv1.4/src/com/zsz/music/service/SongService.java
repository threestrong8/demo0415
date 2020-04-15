package com.zsz.music.service;

import java.util.List;

import com.zsz.music.po.Song;
import com.zsz.music.vo.SongView;

public interface SongService {
   public void uploadSong(Song song);
   public void deleteMySong(int songId);
   public List<Song> getMySongList(int uid,int pc,int ps);
   public List<SongView> getAllSongList(int pc,int ps);
   public int getMyTotalPages(int userId,int ps);
   public int getAllTotalPages(int ps);
   public Song PreEditMySong(int songId);
   public void editMySong(Song song);
   public Song getMySongById(int songId);
}
