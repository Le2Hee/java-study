package edu.java.model;

import java.time.LocalDateTime;

public class Post {
	 private int pid;
	 private String title;
	 private String content;
	 private String author;
	 private LocalDateTime createdTime;
	 private LocalDateTime modifiedTime;
	 
	 public Post() {}
	
	public Post(int pid, String title, String content, String author, LocalDateTime createdTime, LocalDateTime modifiedTime) {
		this.pid = pid;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public void setModifiedTime (LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}
	
	@Override
	public String toString() {
		return "Post (Title : " + title + ", Content : " + content + ", Author : " + author + ", 만든 시간 : " + getCreatedTime() + "수정 시간 : " +
								getModifiedTime() + ")";
	}
	
	 
	
	
}
