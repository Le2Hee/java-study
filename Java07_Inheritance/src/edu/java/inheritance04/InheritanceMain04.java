package edu.java.inheritance04;

public class InheritanceMain04 {

	public static void main(String[] args) {
		// 다형성과 타입 변환(casting) 연산자
		// 다형성 이란? 
		  // SuperType var = new SubType();
		Parent ch1 = new Child();
		ch1.testParent();
//		ch1.testChild(); 
		// -> 실제 생성된 객체는 Child타입이지만, 변수 선언이 Parent타입으로 되어 있어서
		//    Parent 타입에서 정의된 메서들만 보이고 사용할 수 있다.
		// testChild를 만들었는데 에러가 난다.
		// 에러메세지 -> testChild메서드를 Parent타입/클래스에서 testChild메서드가 없다.
		
		((Child) ch1).testChild();
		// Parent 타입으로 선언되 변수를 Child 타입으로 강제 타입 변환(casting)을 하면
		//   Child 타입에서 정의된 메서드들도 보이고 사용할 수 있다.
		// int를 double 타입으로 바꿀때 (double)x로 하는 것과 똑같다.
		  // -> 이런걸 casting하는 것.
		// Parent ch1을 Child타입으로 casting해 타입을 변환시킨후 메서드를 사용하는 것.
		
		Parent ch2 = new AnotherChild();
//		((Child) ch2).testChild();
		// 새로운 객체는 AnotherChild로 생성했지만 Child를 써도 문법적으로는 오류가 나지 않는다.
		//   -> 실행할때 에러가 난다.
		//   -> Child와 AnotherChild는 서로 casting할 수 없는 타입이기 때문에 실행 중에 에러가 발생.
		// 에러 메세지 -> 클래스 타입 변환할떄 에러가 발생했다.
		
		// casting 할때에 안전하게 하는 방법은
		// instanceof 연산자 : (변수 instanceof 클래스 이름.)
		// 변수 클래스 타입의 인스턴스이면 true, 그렇지 않으면 false.
		if (ch2 instanceof Child) {
			((Child) ch2).testChild();
		} else if (ch2 instanceof AnotherChild) {
			((AnotherChild) ch2).testAnotherChild();
		} else {
			ch2.testParent();
		}
		// 검사를 먼저하고 casting을 해서 안전하게 casting을 할 수 있다.
		// instanceof -> 인스턴스냐 ~의 이라는 뜻.
		
		
		
	}

}


class Parent {
	public void testParent() {
		System.out.println("I'm your father!");
	}
}


class Child extends Parent {
	public void testChild() {
		System.out.println("child");
	}
}


class AnotherChild extends Parent {
	public void testAnotherChild() {
		System.out.println("another child");
	}
}

