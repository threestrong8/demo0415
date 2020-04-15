package com.zsz.music.vo;

import java.util.Date;

public class SongView {
	  private int SongId;
	  private int collectionId;
	  private String songName;
	  private String special;
	  private String singer;
	  private Date time;
	  private String path;
	  private int userId;
	  private  String userName;
	
	public int getSongId() {
		return SongId;
	}
	public void setSongId(int songId) {
		SongId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	 public int getCollectionId() {
			return collectionId;
		}
		public void setCollectionId(int collectionId) {
			this.collectionId = collectionId;
		}
	@Override
	public String toString() {
		return "SongView [id=" + SongId + ", songName=" + songName + ", special="
				+ special + ", singer=" + singer + ", time=" + time + ", path="
				+ path + ", userId=" + userId + ", userName=" + userName + "]";
	}
	  
}
