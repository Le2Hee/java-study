package edu.java.modifier02;

import edu.java.modifier01.AccessTest;

// import문
  // 1. 같은 패키지에 있는 클래스는 import 선언문 없이 변수 선언에서 사용할 수 있다.
  // 2. 다른 패키지에 있는 클래스는
    // (1) import 선언문을 작성하고 변수 선언에서 사용할 수 있다. (대부분 (1) 사용)
    // (2) import 선언문 없이, 패키지 이름을 포함한 클래스 전체 이름(full name)을
//          변수 선언과 생성자 호출에서 사용.
      // (2)-1 다른 패키지에서 같은 클래스의 이름을 사용하는 상황에서 사용하게 된다.
      // (2)-2 하나는 import문을 사용하고 다른 하나는 (2)으로 사용하는 방법.
  // 3. import문 없이 사용하는 클래스
    // JDK의 패키지 중에서 java.lang 패키지의 클래스들은 import 선언문 없이
//     클래스 이름을 사용
    // (예) String, System, Math, ...
    // java.lang 안에는 무조건 필수적인 것들만 있다.

  // 참고 (java에서 관습)
    // 패키지 이름을 회사 도메인(naver.com, kakao.com, google.com)을 이용하는 이유는
    // 클래스 이름이 같더라도 다른 패키지 이름으로 구별할 수 있도록 하기 위해서이다.

// import문의 목적은 전체 이름을 줄여서 사용하기 위해서이다.

public class ModifierMain02 {

	public static void main(String[] args) {
		// import 선언문 2 - (2) 예제
//		edu.java.modifier01.AccessTest Test = new edu.java.modifier01.AccessTest(1, 2, 3, 4);
		// 윗 코드를 쓰면 같은 프로젝트 안에서의 클래스들이 나온다.
		  // 2-(2)의 full name이 뜻하는 full name은 이렇게 사용하는 것이다.
		
		// import 선언문 2 - (1) 예제
		AccessTest test= new AccessTest(1, 2, 3, 4);
		  // 윗 쪽에 import문이 없으면 에러가 나온다.
		
		// Ctrl + Shift + O : import 선언문 최적화(optimize)
		  // - 필요한 import문은 자동으로 추가 해주고.
		  // - 필요없는 import문은 자동으로 삭제를 해준다.
		
		test.printInfo();
		
		
	}

}
