package edu.java.class06;

public class ClassMain06 {

	public static void main(String[] args) {
		Circle circle1 = new Circle();
		circle1.printInfo();
		
		Circle circle2 = new Circle(4.5);
		circle2.printInfo();
		
		System.out.println("둘레 : " + circle2.perimeter());
		System.out.println("넓이 : " + circle2.area());
		
		
		
		
	}

}
