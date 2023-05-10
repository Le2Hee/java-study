package edu.java.inheritance05;

// 간단하게 키워드만 보는 용도
class Test {
	private int x;
	protected int y; // protected를 수식하면 하위 클래스에서 바로 변수가 보인다.
	
	public Test(int x, int y) {
//		super(); -> Object 생성자 생략
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	
	
}

class TestChild extends Test {
	private int z;
	
	public TestChild(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	public void printInfo() {
		System.out.printf("x = %d, y = %d, z = %d\n", getX(), y, z);
		// private : 자기 자신 클래스에서만 직접 접근(사용) 
		// -> 상속하는 하위 클래스에서도 보이지 않음(not visible).
		// protected : 같은 클래스 or 상속하는 클래스에서 직접 접근(사용).
	}
	
	
}
