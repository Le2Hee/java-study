package edu.java.inheritance05;

// final -> 변경할 수 없는.
// final 지역 변수 (지역 변수에서 쓸 수 있는 수식어는 final 밖에 없음).
  // -> 값을 한 번 초기화하면 그 값을 변경할 수 없는 변수(상수, constant)

// final 필드
  // -> 반드시 명시적으로 값을 초기화해야 하고, 초기화된 이후에는 값을 변경할 수 없는 필드.
    // 반드시 명시적으로 의 뜻 : 
      // (1) final 필드를 선언할 때 초기화하거나, 또는
      // (2) final 필드를 초기화하는 생성자가 반드시 있어야 한다.

// final 메서드
  // -> override할 수 없는 메서드.
  // -> 하위 클래스에서 재정의할 수 없도록 선언한 메서드.

// final 클래스
  // -> 확장할 수 없는 클래스.
  // -> 상속할 수 없는 클래스.
  // -> (예) java.lang.System, java.lang.String, ... 

// 클래스를 변경한다는 의미 :
  // 클래스를 확장하는 것.(더 많은 필드, 정보)



// final 메서드 예시 :
class A {
	public void test1() {
		System.out.println("test1");
	}
	
	public final void test2() {
		System.out.println("test2");
	}
	
}

class B extends A {
	@Override
	public void test1() {
		System.out.println("B::test1()");
	}
	
//	public void test2() { // final 메서드 : override할 수 없는 메서드.
//		// 오버라이드를 쓰지 않아도 에러가 뜬다.
//		// 에러 메세지 -> A클래스에 있는 final 메서드는 override할 수 없다. 
//	}
	
}

// final 클래스 예시 :
//class MyString extends String {
//	// 에러 메세지 -> String이라는 클래스는 final클래스 이다. 그래서 하위 클래스를 만들 수 없다.
//	// final 클래스는 상속할 수 없는 클래스이다.
//  // final 클래스 여도 부모 클래스가 없는건 아니다.(Object 클래스).
//}



public class InheritanceMain05 {
	private final int x = 1; // final 필드를 선언하면서 초기화.
	private int y;  // 생서자에서 명시적으로 초기화는 코드가 있어야 함.
	
	public InheritanceMain05(int y) {
		this.y = y; // final 필드 y를 초기화.
	}
	
	
	public static void main(String[] args) {
		A a1 = new A();
		a1.test1();
		a1.test2();
		
		
	}

}
