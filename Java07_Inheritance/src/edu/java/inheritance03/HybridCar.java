package edu.java.inheritance03;

// 하이브리드 자동차는 자동차이다.(IS-A관계)
public class HybridCar extends Car {
	// field
	private int battery;
	
	// constructor
	public HybridCar(double fuel, double speed, int battery) {
		super(fuel, speed);
		// -> 상위 클래스에 기본 생성자가 없기 때문에,
		//    반드시 argument를 갖는 super 생성자를 명시적으로 호출해야 함!
		// -> 하위 클래스 필드를 초기화하는 코드는 super 생성자 호출 이후에 작성.
		this.battery = battery;
	}
	
	@Override // 애너테이션(annotation)
	 // 주석은 아니고 java 컴파일러 한테 override라는걸 알려줘서 확인(검사)을 해라라고 알려주는 것.
	 // 애너테이션을 붙여 주는 것이 좋다.
	 // 쓰고 안쓰고의 차이점 : 
	    // @Override라고 선언을 하면 슈퍼 클래스에 똑같은 메서드가 있는지 검사를 해준다.1
	public void drive() {
		System.out.printf("하이브리드 자동차 : 속력 : %f, 연료 : %f, 배터리 : %d\n", 
				getSpeed(), getFuel(), this.battery);
//		super.drive(); //상위 타입 객체가 가지고 있는 (override 전) 메서드를 호출.
//		System.out.println("--- 배터리 : " + battery);
	}
	
	// 오버로딩 과 오버라이드를 헷갈려하는 경우가 많다.
	
	// 오버로딩
	 // 메서드, 생성자 overloading : 
	    // 파라미터가 다를 때, 같은 이름으로 메서드/생성자를 여러개 작성하는 것.
	    // loading -> 트럭이나 배같은 곳에 짐을 놓는다./ 총을 장전하다.
	
	// 오버라이드
	 // 메서드 overriding : 
	    // 상위 클래스의 메서드를 하위 클래스에서 재정의하는 것.
	    // 리턴 타입, 메서드 이름, 파라미터 선언이 모두 같아야 한다.
	    // 접근 제한 수식어는 상위 클래스의 수식어보다 범위가 더 넓거나 같으면 된다.
	    // -> 부모가 public이라 했는데 자식이 private로 선언할 수 없다.
	 // 상위 클래스의 메서드를 하위 클래스 메서드가 덮어버린다고 생각하면 된다.
	
}
