package edu.java.modifier07;

// 객체 (object) : 프로그램에서 사용하려는 대상.

// 클래스(class) : 객체를 만들기 위해서 작성한 코드.
  // - 객체의 속성을 필드로 선언하고, 속성을 초기화하는 생성자를 가질 수 있고,
  //   객체의 속성을 사용한 기능을 메서드로 정의하는 데이터 타입.

// 인스턴스(instance) : 생성된 객체.

// 인스턴스 멤버(필드, 메서드) :
  // - static 수식어가 사용되지 않은 멤버.
  // - 객체를 생성한 후에 참조 변수를 사용해서 접근(사용)할 수 있음.
  // - JRE(Java Runtime Environment)이 사용하는 메모리 공간 중에서 힙(heep)에 생성된다.

// static 멤버(필드, 메서드) : 
  // - 가장 대표적인 static 메서드가 main 이다.
  // - static 수식어가 사용된 멤버.
  // - 객체를 생성하지 않고(생성자를 호출하지 않고) 사용할 수 있는 멤버.
  //   (그 변수가 이미 메모리에 만들어져 있어야된다.)
  // - 프로그램 로딩 시점(main 메서드 시작 전)에 JRE이 사용하는 메모리 공간 중에서 
  //   메서드(method) 영역에 필드라는 메서드들이 생성됨. 
  // - 클래스 이름을 사용해서 사용하는 멤버. ((Class이름.)해서 사용)
  // - (주의) static 메서드는 다른 static 멤버(필드, 메서드)들만 사용 가능하다.
    // -> static 메서드는 인스턴스 멤버(필드, 메서드)를 사용할 수 없다!!!

// static이 꼭 필요한 경우가 있는데 그럴때만 static을 사용하고 가능하면 안사용하는것이 좋다.
// static은 로딩 시점에 메모리가 생성되기 때문에 프로그램을 종료를 해야 사라진다.(method 영역)
// static이 많으면 많을수록 프로그램이 사용되는 용량이 커지게 된다.
// 클래스 이름만 알면 막 접근할 수 있다.

public class ModifierMain07 {
	
	public static void test1() {
		System.out.println("test 1");
	}
	
	public void test2() {
		System.out.println("test2");
	}
	
	public static void main(String[] args) {
		// main은 왜 static 일까?
		  // JRM이 호출할때 main이 실행 준비가 끝나야 실행 하는 것이 맞기 때문이다.
		
		Test.printStaticInfo();
		// static 메서드는 (객체 생성 여부와 상관 없이) 클래스 이름을 사용해서 호출 가능하다.
		  // -> static이라고 생성되면 객체를 붙히지 않아도 바로 사용가능하다. (Test.)
		// static 필드는 (객체 생성 여부와 상관 없이) 클래스 이름을 사용해서 접근(사용)
		Test.y = 456;
		Test.printStaticInfo();
		
		// Test 타입의 객체 생성
		Test test = new Test();  // test : 참조 변수
		
		// 참조변수 test를 사용해서 인스턴스 메서드 호출.
		test.printInfo(); 
		
		// 참조변수 test를 사용해서 인스턴스가 가지고 있는 변수(필드)를 사용할수 있다.
		test.x = 100;
		test.printInfo();
		
		
		test1(); // 같은 클래스에 있는 메서드이기 때문에 클래스 이름을 생략해도 문제 없다.
		         // static 메서드는 static 멤버(필드, 메서드)를 사용할 수 있음.
		         // -> main도 static이고 test1도 static이기 때문에 사용할 수 있다.
//		test2(); // static 메서드에서 인스턴스 멤버(필드, 메서드)를 사용할 수 없음!!!
		         // -> static이 아닌 메서드이기 때문에 static인 main은 사용할 수 없다.
		
		// test2라고 하는 메서드가 들어있는 ModifierMain07라는 객체를 먼저 생성해야 한다.
		ModifierMain07 app = new ModifierMain07(); // 기본 생성자(생성자가 없기 때문에)
		app.test2();
		
	}
	
	
}
