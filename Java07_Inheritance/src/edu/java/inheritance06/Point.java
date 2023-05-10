package edu.java.inheritance06;

import java.util.Objects;

public class Point {
	private int x;
	private int y;
	
	
	// 생성자 : (1) 기본 생성자, (2) argument가 2개인 생성자.
	public Point() {}


	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// getter & setter
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	// toString override : "Point(x : 0, Y : 0)"
	@Override
	public String toString() {
//		return "Point(x : " + this.x + ", Y : " + this.y + ")";
		String s = String.format("Point(x : %d, y : %d)", this.x, this.y);
		// printf 랑 똑같지만 printf는 리턴값이 없이 출력만해주고 
	    // String.format은 문자열을 만들어서 변수에 저장해준다.
		return s;
	}

	// equals()메서드를 만들때 "무조건 반드시" hashCode()도 override를 해야된다.
	// hashCode()를 같이 안하면 다른 클래스에 들어가 있는 equals()들이 이상해져 
	//  이클립스의 기능들을 제대로 사용못할 수 있다.
	
	// hashCode() 메서드 :
	  // 반드시 int 타입을 리턴.
	  // equals()가 true를 리턴하는 두 객체는 hashCode()의 리턴값이 같아야 함.
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
		// equals()에 들어가는 값이 2개를 넣는다.(3개면 3개, ...)
//		return x * 100 + y * 10; // -> 대충 만든 거임. 코드 중요 x
		// equals() true면 A의 x,y 와 B의 x,y는 같다.
		// 그럼 리턴되는 값은 결국 둘 다 같다. -> 무한하게 많다.
	}
	
	// --기타 정보--
	// hash라는 알고리즘이 사용되는 클래스들이 있다.
	// equals()가 객체를 확인하기 전에 hash가 먼저 확인한다.


//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass()) // 클래스 이름이 다르면 
//			return false;				  //같은 타입의 instance인지 구별하는 것.
//		// 클래스 이름이 같으면 -> casting을 할 수 있다.
//		Point other = (Point) obj;
//		return x == other.x && y == other.y;
//	}
	
	// 윗 메서드와 같은 내용의 메서드
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Point) { // obj가 Point 타입의 인스턴스이면
			Point other = (Point) obj; // 안전한 타입 변화(casting)
			result = (this.x == other.x) && (this.y == other.y);
		}
		
		return result;
	}
	
	
	
}
