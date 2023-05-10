package edu.java.inheritance03;

public class InheritanceMain03 {

	public static void main(String[] args) {
		// Car 타입의 객체 생성
		Car car1 = new Car(100, 30);
		car1.drive();
		
		// HybridCar 타입의 객체 생성
		HybridCar car2 = new HybridCar(90, 50, 100);
		car2.drive();
		
		// 다형성(polymorphism) : 
		  // 하나의 객체를 두 개 이상의 타입으로 부를 수 있는 것.
		  // 객체를 자기 자신 타입 뿐만 아니라 그 "상위 타입" 변수에도 할달할 수 있는 것. 
		  // 하이브리드지동차는 "하이브리드 자동차다."
		  // 하이브리드자동차는 "자동차이다"
		Car car3 = new HybridCar(100, 50, 100); 
		 // 상위클래스 타입으로 불러서 사용가능하지만, 하위클래스 메서브를 불러올수없다. 
		car3.drive(); // -> 다형성이 적용된 경우에도, override되어 있는 메서드가 실행됨.
		
		// 다형성은 코드의 재사용성(reuse)을 높여줌.
		// 변수 선언, 배열/리스트 선언 파라미터 선언, 메서드 리턴 타입 선언, ...
		  // -> 이런 여러가지 부분에서 다형성이 이용될 수 있다.
		// SuperType var = new SuperType(); 
		// SuperType var = new SubType);
		// SuperType[] arr = {new SuperType(), new SubType()};
		Car[] cars = {car1, car2, car3};
		// 배열의 장점은 반복문을 써서 cars가 들고있는 메서드를 호출하는 것.
		for (Car c : cars) {
			c.drive();
		}
		
		// 다향성을 사용해서 정의된 메서드.
		//System.out.println(Object o);
		  // -> 어떤 타입의 객체도 모우 argument로 전달할 수 있음.
		  // -> 클래스를 만들때 마다 계속 새로운 println의 메서드를 만들수는 없기 때문에
		  //    Object를 선언해버리면 모든 타입의 객체를 받을 수 있다.
		  // -> 모든 클래스의 상위 클래스는 object이기 때문이다.
		System.out.println(car1);
		System.out.println(car2);
		
		
		
		
	}

}
