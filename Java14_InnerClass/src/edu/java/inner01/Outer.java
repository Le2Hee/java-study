package edu.java.inner01;

public class Outer {
	// field
	private int x;
	private String s;
	private int y;
	
	// constructor
	public Outer(int x, int y, String s) {
		this.x = x;
		this.s = s;
		this.y = y; // 외부 내부 클래스 y를 구별할 수 있다.
	}
	
	// method
	@Override
	public String toString() {
		return String.format("Outer(x = %d, y = %d, s = %s)", x, y, s);
	}
	
	// static이 아닌 멤버 내부 클래스(인스턴스 내부 클래스)
	public class Inner {
		// field
		private int y;
		
		// constructor
		public Inner (int y) {
			this.y = y;
		}
		
		// method
		public void printInfo() {
			System.out.println("---- Inner Class ----");
			System.out.println("y = " + y); //(this.y 를 생략한것)
			// -> 가까이 있는 변수를 찾아간다.
			// -> 내부 클래스의 멤버 y를 찾아간다.
			System.out.println("Outer x = " + x); //(Outer.this.x 를 생략한것)
			// -> 내부 클래스는 외부 클래스의 멤버들을 사용할 수 있다.
			// -> 외부 클래스에 가지고 있는 객체를 내부 클래스에서 접근할수 있다.
			// -> 상속이 아니라 안에 포함되어 있으니까.
			System.out.println("Outer y = " + Outer.this.y);
			// -> Outer클래스가 가지고 있는 변수 y
			System.out.println("Outer s = " + s);
			
		}
		
	}
	
	
}
