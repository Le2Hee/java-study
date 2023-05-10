package edu.java.model;

import java.io.Serializable;

public class User implements Serializable{
	
	public interface Entity {
		String TBL_NAME = "USERS";
		String COL_USERID = "USERID";
		String COL_USERPW = "USERPW";
		String COL_NICKNAME = "NICKNAME";
	}
	
	private String userId; // 유저 아이디
	private String userPW; // 유저 비밀번호
	private String nickname; // 유저 닉네임
	
	public User() {}

	public User(String userId, String userPW, String nickname) {
		this.userId = userId;
		this.userPW = userPW;
		this.nickname = nickname;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getNickname() {
		return nickname;
	}

	
}
