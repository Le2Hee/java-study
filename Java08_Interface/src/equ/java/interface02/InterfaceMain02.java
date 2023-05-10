package equ.java.interface02;

// 인터페이스가 가질 수 있는 멤버들 :  []은 생략 가능.
 // Java 7, 8, 9 이후 3개로 나뉜다.
   // 1. [public static final] 필드 -> Java 7 버전까지.

   // 2. [public abstract] 메서드 -> 기존 interface -> Java 7 버전 부터 사용 가능.
   //    -> (하위) 클래스에서 구현하는 것을 목적으로 하는 메서드.

   // 3. [public] default 메서드 : body가 구현된 메서드 -> Java 8 버전 부터 사용 가능.
   //    -> 인터페이스를 구현하는 (하위) 클래스의 객체를 생성한 후에 사용하는 메서드.

   // 4. [public] static 메서드 : body가 구현된 static 메서드 -> Java 8 버전 부터 사용 가능.
   //    -> 객체 생성 없이 인터페이스 이름 또는 구현하고 있는 (하위)클래스 이름으로 접근(.)해서 
   //       사용하는 메서드.

   // 5. private static 메서드 : body가 구현된 private static 메서드. -> Java 9 버전 부터 사용 가능.
   //    -> 인터베이스의 default 메서드(3)와 static 메서드(4) 안에서만 사용하기 위한 메서드.

   // 6. private 메서드 : body가 구현된 private메서드. Java 9 버전 부터 사용 가능.
   //    -> 인터베이스의 default 메서드(3)에서만 사용하기 위한 메서드.

interface Test {
	// 1. [public static final] 필드
	int VERSION = 1;
	
	// 2. [public abstract] 메서드 :
	void test();
	
	// 3. [public] default 메서드 :
	default void defaultMethod() {
		System.out.println("공개 디폴트 메서드");
	}
	// default 를 안붙히면 추상메서드가 되고 그러면 body를 가질수 없기 때문에 default 생략 불가능.
	// 객체를 만들어야지만 사용 가능.
	
	// 4. [public] static 메서드 : 
	static void staticMathod() {
		System.out.println("공개 stati 메서드");
	}
	// static 를 안붙히면 추상메서드가 되고 그러면 body를 가질수 없기 때문에 static 생략 불가능.
	// 객체를 만들어야지만 사용 가능.
	
	// 5. private static 메서드 : 
	private static void privateStatiMathod() {
		System.out.println("비공개 static 메서드");
	}
	// 3번 메서드에서 사용가능하다.
	// static 메서드 안에 코드를 간단하고 나만 사용할수 있게 기능을 업그레이드를 하자.
	
	// 6. private 메서드 : 
	private void privateInstanceMethod() {
		System.out.println("비공개 인스턴스 메서드");
	}
	// static 안붙어져 있어서 객체를 만들어서 사용해야 된다.
	// 6번은 무조건 default 메서드에서 사용할 목적으로 만들어진 문법이다.
	
}

class TestImpl implements Test {
	@Override
	public void test() {
		System.out.println("인터페이스 추상 메서드 구현");
	}
	
	// 윗 메서드는 추상메서드이기 때문에 무조건 사용.
	// 다른 메서드들은 알아서 상속받아서 사용하면 됨.
	
}

public class InterfaceMain02 {

	public static void main(String[] args) {
		System.out.println(Test.VERSION);
		Test.staticMathod();
		// 인터페이스를 구현하지 않아도 static 메서드는 사용가능하다.
		// 나머지는 객체 생성 후 사용할 수 있는것들이다.
		
		Test t = new TestImpl(); // 인터페이스 구현 객체 생성.
		t.test(); // 하위 클래스(TestImpl)에서 구현한 메서드  
		t.defaultMethod(); // interface에서 기본(default)으로 구현되어 있는 메서드. 
		// 										             -> (body를 가지고 있는.)
		
		
	}

}
