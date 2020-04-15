package com.zsz.music.po;

public class User {
   private int id;
   private String userName;
   private String email;
   private String pwd;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", email=" + email
			+ ", pwd=" + pwd + "]";
}
   
}
