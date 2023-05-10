package edu.java.inheritance08;

public class InheritanceMain08 {

	public static void main(String[] args) {
//		Shape shape = new Shape("직사각형");
		// 추상 클래스는 생성자를 호출할 수 없다. -> 객체를 생성할 수 없다.
		// protected는 같은 팩키지에 있거나 상속하는 클래스에서 쓸 수 있다.
		// 그런데 Shape은 보이지만 쓸 수가 없다.
		
		Rectangle rec = new Rectangle("직사각형", 30, 90);
		System.out.println("넓이는 : " + rec.area());
		System.out.println("둘레는 : " + rec.perimeter());
		rec.draw();
		
		Circle cir = new Circle("원", 5.83);
		System.out.println("원 넓이 : " + cir.area());
		System.out.println("원 둘레 : " + cir.perimeter());
		cir.draw();
		
		System.out.println("====================================================================");
		// 해석
		Shape[] shapes = {
				new Rectangle("직사각형", 3, 4),
				new Circle("원", 10)
		};
		for (Shape s : shapes) { // 직사각형, 원을 꺼내지만 Shape타입이다.
			s.draw(); // Shape에서 만들어진 method
			// draw는 shapes에 나오는 메서드 이다.
			// 하는 역할은 콘솔창에 문자열을 출력해준다.
		}
		
	}

}
