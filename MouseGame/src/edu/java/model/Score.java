package edu.java.model;

import java.io.Serializable;

public class Score implements Serializable {
	
	public interface Entity {
		String TBL_SCNAME = "SCORES";
		String COL_SCNICKNAME = "NICKNAME";
		String COL_TIME = "TIME";
	}
	
	private String nickname;
	private Long time; 
	
	public Score() {}

	public Score(String nickname, Long time) {
		this.nickname = nickname;
		this.time = time;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}


}
