package edu.java.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle();
		rect1.PrintInfo();
		
		Rectangle rect2 = new Rectangle(20, 50);
		rect2.PrintInfo();
		
		System.out.println("둘레는 : " + rect2.perimeter());
		System.out.println("넓이는 : " + rect2.area());
		
		System.out.println("=======================================================");
		
		// 풀이
		// 기본 생성자를 이용한 Rectangle 객체 생성
		Rectangle rect3 = new Rectangle();
		System.out.println(rect3); // 16진법 @(0~9, a, b, c, d, e, f)
		System.out.println(rect3.width + ", " + rect3.height);
		// 생성자가 하는 일
		 // - "Rectangle rect3 = new Rectangle();"
		  // - 메모리를 확보해 주는 것.
		  // - 메모리를 구별하는 숫자를 지역 변수가 저장하는 것.
		
		// "." 을 참조연산자라고 한다.
		
		rect3.width = 1.0; // 생성된 rect3 직사각형 객체의 가로 길이(width)를 변경.
		rect3.height = 2.0; // 생선된 rect3 직사각형 객체의 세로 길이(height)를 변경.
		// 기본 생성자로 설정해도 변수의 이름이 보이면 직접 값을 바꿀수 있다.
		
		System.out.println(rect3.perimeter());
		System.out.println(rect3.area());
		
		System.out.println("=======================================================");
		
		// argument를 갖는 생성자를 이용한 Rectangle 객체 생성.
		Rectangle rect4 = new Rectangle(4, 3);
		System.out.println(rect4);
		rect4.PrintInfo(); //System.out.println(rect4.width + ", " + rect4.height);
		
		System.out.println("둘레 : " + rect4.perimeter());
		System.out.println("넓이 : " + rect4.area());
		
	}

}
