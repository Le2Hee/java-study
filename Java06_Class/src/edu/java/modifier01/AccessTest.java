package edu.java.modifier01;

public class AccessTest {
	// field
	private int a; // 같은 클래스 안에서만  , 빨간색
	int b; // 패키지 범위  , 파란색
	protected int c; // 같은 패키지 안에 있거나(or) 상속하는 경우  , 노란색
	public int d; // 어디서든  , 초록색
	
	public AccessTest(int a, int b, int c, int d) {
		this.a = a; 
		this.b = b; 
		this.c = c; 
		this.d = d;  
	}
	
	public void printInfo() {
		System.out.printf("A : %d, B : %d, C : %d. D : %d\n", 
				this.a, this.b, this.c, this.d);
	}
	
	
	
	
}
