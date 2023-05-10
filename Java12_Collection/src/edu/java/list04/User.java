package edu.java.list04;

public class User {
	// fields : 
	private String id;
	private String password;
	
	
	// 생성자 : 
	// (1) 기본 생성자, (2) 아규먼트 2개를 갖는 생성자
	public User() {}


	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	// getters & setters
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	// toString() override
	// 하기 전과 하고 난 후 비교하기.
	// 하기 전 -> 주소 값나옴.
	// 하고 난 후 -> 저장된 속성들 나옴.
	@Override
	public String toString() {
		return String.format("유저 정보(아이디 : %s, 비밀번호 : %s)\n", id, password);
	}
	
}
