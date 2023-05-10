package edu.java.inheritance08;

public abstract class Shape {
	// field
	protected String type;
	
	// constructor
	// 추상 클래스의 생성자는 하위 클래스에서만 호출할 수 있다.
	protected Shape(String type) {
		this.type = type;
	}
	
	// method
	// 추상 메서드
	public abstract double area(); // 도형의 넓이를 리턴.
	public abstract double perimeter(); // 도형의 둘레 길이를 리턴.
	
	// final 메서드
	public final void draw() {
		String info = String.format("%s : 넓이 = %f, 둘레 = %f", 
				this.type, area(), perimeter());
		  //  ->  바디가 없는 메서드를 호출한다. 
		  //  ->  final로 만든 목적 : 하위 클래스에서 override(재정의)하지 못하도록 하기 위해서.
		  //  ->  메서드가 추상인 상태로 남아있는걸 사용하지 못하지만,
		  //  ->  이 메서드를 사용할때에 누군가 사용할때 객체와 메서드를 만들고 사용하겠지 라고 
		  //      생각하고 진행한다.
		System.out.println(info);
	}
	
	
	
}
