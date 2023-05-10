package edu.java.modifier01;

import edu.java.class08.Account;
 // 다른 패키지의 클래스를 사용할 때. (import문을 사용한다.)


// 클래스 멤버(필드, 생성자, 메서드)의 접근 제한 수식어(access modifier)
// 1. private - 개인적인, 사적인
   // 선언된 클래스 안에서만 직접 접근해서(사용) 가능.
   // 다른 클래스에서 보이지 않는다.
   // 같은 클래스 안에서 메서드들은 사용가능 하다.
// 2. (package) - (package를 직접 적는게 아님.)
   // 수식어가 없는 경우로 같은 패키지에 있는 클래스들에서 직접 접근(사용) 가능.
   // 패키지에서 보인다 해서 (package)
// 3. protected 
   // 같은 패키지에 있거나 또는 상속하는 클래스들에서 직접 접근(사용) 가능.
// 4. public - 공공의, 공개되어져있는
   // 어디서든(어떤 클래스든 다른 패키지든 같은 패키지든) 직접 접근(사용) 가능.

// 위 4가지를 가시성(visibility) 라고한다.
// 가시성(visibility)
   // 범위 : private < (package) < protected < public

// class는 public이냐 (package)이냐 2개로 나눠진다.

// 지역 변수는 가시성타입을 적을 수 없다.
  // 당연히 지역 변수는 메서드가 실행되면 생기고 끝나면 사라지기 때문이다.

public class ModifierMain01 {

	public static void main(String[] args) {
		Account acc = new Account(111, 10000); // class08번에서 사용한 class
//		acc.balance = 100;  -> 에러 경고문 안에서  
		   // not visible : 수식어가 없는 경우 다른 패키지 에서 보이지 않는다.
//		                   (있는데 보이지 않는다.) 
		
		acc.printInfo();
		   // "." public로 공개되어 있는 메서드를 이용
           // printInfo를 넘어가면 Account의 변수를 사용할수 있기때문에 가능.
		   // public으로 공개된 메서드는 어디서든지 사용 가능.
		
		// 직접 변수값을 바꿀순 없지만, Account안 메서드를 이용해 간접적으로 변경 가능.
		
		// 같은 패키지에 있는 클래스 타입은 import 문장 없이 사용 가능.
		AccessTest test = new AccessTest(1, 2, 3, 4);
//		System.out.println(test.a); -> 에러 경고문 : not visible : private
		 // a는 private이기 때문에 다른 클래스에서 사용할 수 없다.
		System.out.println(test.b);
		 // 수식어가 없는 경우 같은 패키지 범위에서는 보임.
		test.printInfo();
		 // 생선된 객체를 통해서 직접 보이지 않지만, 생선된 메서드를 통해서 알 수 있다.
		
		test.d = 100; // 보이는 것은 쓸수있다. (변경 가능)
//		test.a = 100;    안보이니까 변경도 당연히 불가. (not visible)
		test.printInfo();
		
		// 생성자를 private으로 선언하면 다른 클래스에서는 생성자를 호출할 수 없기 
//		   때문에 객체를 생성할 수 없습니다.
//		new Math();  JDK java.lang.Math 클래스의 생성자는 private -> 객체 생성 불가능.
		
		
		
	}

}
