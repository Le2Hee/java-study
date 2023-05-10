package edu.java.inheritance06;

import java.util.Objects;

public class User {
	// field
	private String userId;
	private String password;
	
	// 생성자
	 // (1) 기본생성자
	 // (2) argument 2개를 갖는 생성자.
	public User() {}
	
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	// getters & setters
	public String getUserId() {
		return this.userId;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	// toString() override
	 // 출력문 예시 : "User(userId = ..., password = ...)"
	@Override
	public String toString() {
		String s = String.format("User(userId : %s, password : %s)", this.userId, this.password);
		return s;
	}
	
	// hashCode() override -> 알아서
	@Override
	// equals()의 결과가 true이면 hashCode()의 리턴 값이 같다. 
	public int hashCode() {
		return Objects.hash(userId);
//		if (this.userId == null) { // -> null이 들어가 있으면 hashCode도 안나온다.
//			return 0;
//		} else {
//			return this.userId.hashCode();
//		}
	}
	
	// equals() override
	 // 두 객체의 userId가 같으면 true, 그렇치 않으면 false
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof User) { // obj가 User타입의 객체가 맞나? 
			User other = (User) obj; // -> 그래야 User타입으로 casting가능 하니까.(문제가 안된다.)
//			result = (this.userId == other.userId); -> 문자열이기 때문에 equals() 메서드 사용.
			if(this.userId != null && this.userId.equals(other.userId)) {
				result = true;
			}
			// 윗 코드(if(equals())는 문제의 소지가 있다.
			 // -> 이 클래스의 생성자에 기본 생성자를 호출하면 null이 되버린다
			 // -> null에서 메서드를 호출하면 오류가 뜬다.
			 // -> 객체가 없는데 메서드를 호출하면 안된다. 객체가 있어야 메서드를 호출할 수 있다.
			 // -> 그래서 앞 쪽에 this.userId가 null이 아니라는 것을 명시 해야된다.
		}
		
		return result;
	}
	
	
	
	
	
}
