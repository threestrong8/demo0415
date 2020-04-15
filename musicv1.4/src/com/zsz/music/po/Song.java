package com.zsz.music.po;

import java.util.Date;

public class Song {
  private int id;
  private String songName;
  private String special;
  private String singer;
  private Date time;
  private String path;
  private int userId;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
@Override
public String toString() {
	return "Song [id=" + id + ", songName=" + songName + ", special=" + special
			+ ", singer=" + singer + ", time=" + time + ", path=" + path
			+ ", userId=" + userId + "]";
}
  
}
