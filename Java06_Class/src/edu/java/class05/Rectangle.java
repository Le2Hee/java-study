package edu.java.class05;

// Rectangle (직사각형)
// 직사각형
public class Rectangle {
	// field - 객체 속성
	double width; // 직사각형 가로 길이
	double height; // 직사각형 세로 길이
	
	// 생성자 - 필드 초기화
	// (1) 기본 생성자
	// (2) 직사각형의 가로/세로 길이를 전달받은 값으로 초기화하는 생성자.
	
	public Rectangle() {}
	
	public Rectangle(double width, double height) {
		this.height = height;
		this.width = width;
	}
	
	// 메서드 - 객체 기능
	// (1) perimeter - 직사각형의 둘레 길이를 리턴.
	// (2) area - 직사각형의 넓이를 리턴.
	
	public double perimeter() {  
		return (height + width) * 2; // this를 안써도 헷갈리지 않다.
	}
	
	public double area() {
		return this.height * this.width; // height * width;
	}
	
	public void PrintInfo() {
		System.out.printf("가로 : %f\n세로 : %f\n", width, height);
	}
	
}
