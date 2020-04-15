package com.zsz.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.zsz.music.mapper.CollectMapper;
import com.zsz.music.mapper.SongMapper;
import com.zsz.music.po.Song;
import com.zsz.music.service.SongService;
import com.zsz.music.vo.SongView;
@Transactional
public class SongServiceImpl implements SongService {
	@Autowired
      private SongMapper songDao;
	@Autowired
	  private CollectMapper collectDao;
	@Override
	public void uploadSong(Song song) {
		songDao.add(song);
	}

	@Override
	public void deleteMySong(int songId) {
		collectDao.deleteBySongId(songId);
		songDao.delete(songId);
	}

	@Override
	public List<Song> getMySongList(int uid, int pc, int ps) {
		return songDao.getMySongList(uid, pc, ps);
	}

	@Override
	public List<SongView> getAllSongList(int pc, int ps) {
		return songDao.getAllSongList(pc, ps);
	}

	@Override
	public int getMyTotalPages(int userId,int ps) {
		int records=songDao.getMyTotalRecords(userId);
		int pages=records%ps==0?records/ps:records/ps+1;
		return pages==0?1:pages;
	}

	@Override
	public int getAllTotalPages(int ps) {
		int records=songDao.getAllTotalRecords();
		int pages=records%ps==0?records/ps:records/ps+1;
		return pages==0?1:pages;
	}

	@Override
	public Song PreEditMySong(int songId) {
		return songDao.getMySongById(songId);

	}

	@Override
	public void editMySong(Song song) {
		songDao.updateMysong(song);
	}

	@Override
	public Song getMySongById(int songId) {
		// TODO Auto-generated method stub
		return songDao.getMySongById(songId);
	}

}
