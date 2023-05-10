package edu.java.jdbc.model;

import java.time.LocalDateTime;

// MVC 아키텍쳐에서 Model에 해당하는 클래스.
// 데이터베이스에서 정의된 테이블의 모양을 자바 클래스로 선언하기 위해서 만드는 클래스.
// 테이블의 컬럼들을 클래스이 필드로 선언.

public class Blog { 
	public interface Entity { // ""들어가는 값이 테이블 이름으로 정확히 해야된다.
		// 테이블 이름과 컬럼 이름들을 상수로 정의.
		String TBL_NAME = "BLOGS";
		String COL_ID = "ID";
		String COL__TITLE = "TITLE";
		String COL_CONTENT = "CONTENT";
		String COL_AUTHOR = "AUTHOR";
		String COL_CREATED_TIME = "CREATED_TIME";
		String COL_MODIFIED_TIME = "MODIFIED_TIME";
	}
	
	// field
	private Integer id; // 블로그 글 번호.
	private String title; // 글 제목.
	private String content; // 글 내용.
	private String author; // 글 작성자.
	private LocalDateTime createdTime; // 글 최초 작성 시간.
	private LocalDateTime modifiedTime; // 글 수정 시간.
	
	// 생성자
	public Blog() {}

	public Blog(Integer id, String title, String content, String author, LocalDateTime creatdTime,
			LocalDateTime modifiedTime) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createdTime = creatdTime;
		this.modifiedTime = modifiedTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDateTime getCreatdTime() {
		return createdTime;
	}

	public void setCreatdTime(LocalDateTime creatdTime) {
		this.createdTime = creatdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	@Override
	public String toString() {
		return String.format("Blog(id = %d, title = %s, content = %s, author = %s, creatdTime = %s, modifiedTime = %s)",
				id, title, content, author, createdTime, modifiedTime);
	}
	
}
