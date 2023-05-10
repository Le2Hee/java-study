package edu.java.modifier03;

public class User {
	// field
	private int userNo;
	private String userId;
	private String password;
	
	// argument 3개를 갖는 생성자
	public User (int userNo, String userId, String password) {
		this.userNo = userNo;
		this.userId = userId;
		this.password = password;
	}
	
	// getter메서드, setter메서드 (3개 변수 전부 다)
	public int getUserNo() {
		return this.userNo;
	}
	
	public String getUserId () {
		return this.userId;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUserNo(int useNo) {
		// 파라미터는 세팅 값이 필요하기 때문에 들어가고, 리턴하는건 없기 때문 void
		// 리턴 타입이 없다.!!!!
		this.userNo = useNo;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
