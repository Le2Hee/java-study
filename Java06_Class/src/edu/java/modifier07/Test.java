package edu.java.modifier07;

public class Test {
	int x; // static이 안붙어있는 필드를 인스턴스 필드라고 한다.
	static int y; // static 필드
	// static을 붙히면 폰트가 달라진다. -> Eclipse 기능. (일반 필드가 아니다라는 것을 구별하기 위해.)
	// static는 class와 무관하게 미리 만들어 진다.
	
	// 인스턴스 메서드
	  // 반드시 객체를 생성해야지만 사용할 수 있다.
	public void printInfo() {
		System.out.println("---instance method---");
		System.out.println("x : " + this.x);
		System.out.println("y : " + y);
		  // -> 인스턴스 메서드는 static 필드or메서드를 사용할 수 있다.
		 // static에는 앞에 this. 을 붙히지 않는다. (붙여도 되긴 한다.)
		  // -> Test.y 라고 해야 맞다.
		System.out.println("---------------------");
	}
	
	public static void printStaticInfo() {
		System.out.println("--- static method ---");
//		System.out.println("x : " + x); 
		 // 에러 내용 : static 아닌 필드 x에 대해서는 static 참조를 만들수 없다.
		 // x는 생성자를 호출하는 시점에서 생성되지만 static은 프로그램을 실행하면 나오기 때문이다.
		 // static 메서드에서 인스턴스 필드or메서드는 사용할 수 없기 때문에 에러가 난다.
		System.out.println("y : " + y);
		System.out.println("---------------------");
	}
	// 수식어 순서는 중요하지 않음. public, static 순서가 바껴도 상관없다.
	// 리턴타입은 메서드 이름 앞에 있어야된다.
	
	
	
}
