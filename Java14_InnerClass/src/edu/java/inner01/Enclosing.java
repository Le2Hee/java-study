package edu.java.inner01;

public class Enclosing {
	public static int var = 123; // static인 경우는 값을 정하는 경우가 많다.
	private int x;
	
	public Enclosing(int x) { // 일반적으로 static은 생성자에서 초기화를 하지않는다.
		this.x = x;
	}
	
	// Enclosing.test() 호출할려는 메서드.
	public static void test() {
		System.out.println(var); // static 맞음. 생성 가능하다.
//		System.out.println(x); // -> static 아님.
		// -> static 멤버는 다른 static 멤버들만 사용가능.
		//    non-static 멤버들은 사용 불가!!!
	}
	
	
	@Override
	public String toString() { 
		// 인스턴스(static이 아닌) 메서드는 static 또는 non-static 멤버를 모두 사용할 수 있다.
		return String.format("Enclosing(var = %d, x = %d)", var, x);
	}
	
	// static 내부 클래스
	//   -> 외부 클래스의 객체 생성 여부와 상관 없이 생성자를 호출할 수 있다!!!
	public static class Nested {
		private int x;
		
		public Nested(int x) {
			this.x = x;
		}
		
		public void printInfo() {
			System.out.println("---- static inner class ----");
			System.out.println("x = " + x); // 내부 클래스 멤버 사용.
//			System.out.println("Enclosing x : " + Enclosing.this.x);
			// static 내부 클래스는 외부클래스에 non-static에 접근할 수 없다.
			// -> static 이니깐.
			System.out.println("Enclosing var : " + var); // Enclosing.var를 생략한 것.
			
		}
		
		
	}
	
	
	
	
}
