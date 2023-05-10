package equ.java.method01;

import java.util.Random;

// java의 method
// 메서드(method) : 클라스 안에서(밖에서 만들수 없음.) 정의하는 기능(함수, function).
// - 함수(function) : 프로그램에서 사용될 기능을 코드 블록으로 작성한 것.
// - 메서드(method) : 클래스 안에서 작성된 함수.
// 자바 언어는 메서드만 제공하고, 함수는 제공하지 않는다!!
// 자바 언어는 메서드 안에서 메서드를 정의하는 것을 제공하지 않는다!!
// (메서드 안에서 메서드를 만들수 없다!)
// function이 더 큰 개념이고 method가 더 작은 개념이다.
// 클라스 안에서 만들면 method라고 하고 전체를 다 합쳐서 함수(function)이라고 한다.
// 자바에서는 함수를 클래스 안에서만 만드는걸 허용한다.

// 메서드 호출(call, invoke) : 메서드를 사용하기 위해서 메서드 이름을 사용하는 것.
// 								(메서드를 사용하는 것.)

// argument : 메서드를 호출할 때 메서드에게 전달하는 값. 
//      	  () 안에 있는 값을 argument 라고 한다.
// 			  예) system.out.println("안녕하세요); 할떄 ("안녕하세요")를 argument
// parameter : 매개변수, argument를 저장하기 위한 메서드의 지역 변수.
// 반환 값(return value) : 메서드가 모든 기능을 수행한 후 메서드를 호출한 곳으로 되돌려 주는 값.
//                         (되돌려주는 값.)
// - 메서드는 반환 값이 있을 수도 있고, 없을 수도 있음
// - println() : 반환 값이 없는 메서드

// - nextInt() : 반환 값이 있는 메서드

// 메서드 정의(선언) 방법 : (메서드를 만드는 구조)
// [수식어] 리턴타입 메서드이름([파라미터 선언, ...]) { ... }
// 메서드의 리턴 값이 없는 경우에는 리턴 타입을 void라고 선언함.
// [] 이 부분은 생략해도 된다. (줄바꿈을 할떄 파라미터를 선언하지 않는다.)
// ()자체를 생략할순 없다.
// 수식어들은 여러개가 있을수도 없을수도 있다.
// 리턴타입과 메서드이름은 생략할수 없다.


public class MethodMain01 {

	// main 메서드(method) : 프로그램 시작점.
	public static void main(String[] args) {
		System.out.println("안녕하세요~");
		// -> println() 메서드를 호출 했다. -> 호출 결과 : 콘솔 창에 문자열을 출력.
		// 안녕하세요를 println에다가 값을 주고 출력해라고 전송.
		// 항상 메서드 뒤에는 ()가 있다. ()는 메서드한테 값을 줄때 ()를 사용하고 
		// ()를 비워두면 전송할 값이 없을때 비워둔다.
		
		Random random = new Random();
		int x = random.nextInt(10);
		//    -> nextInt() 메서드(기능) 호출 -> 10이라는 값을 nextInt에 전달한 것.
		//  -> nextInt() 메서드는 난수를 반환(return).
		System.out.println(x);
		
		System.out.println("테스트1");
		//println은 같은 클래스가 아니기 때문에 부를때 앞에 수식어가 많이 붙는다.
		newLine(); // 같은 클래스에 정의(선언)된 메서드를 호출할때에는 이름만 쓰면됨.
		System.out.println("테스트2");
		
		System.out.println("테스트3");
		newLine(3);
		System.out.println("테스트4");
		
		
	}
	
	/**
	 * 콘솔에 빈 줄 하나를 출력하는 메서드.
	 * *2개가 붙어서 시작하는 주석을 문서화 주석이라고 한다.
	 * 메서드 이름 위에다가 이 주석을 사용하면 자동으로 설명을 등록하게 된다.
	 * main메서드에서 사용한 newLine에 마우스를 가져대면 나옴.
	 * 클래스 위에도 넣을 수 있다.
	 */
	public static void newLine() { //newLine을 호출하면 System.out.println();를 실행하겠다.
		//  			(호출할때 전달할 값이 없다.)
		System.out.println();
	}
	
	
	/**
	 * 콘솔에 n개의 빈 줄을 출력하는 메서드
	 * 
	 * @param n 0 이상의 정수, 출력할 빈 줄의 개수.
	 */
	public static void newLine(int n) { 
		//파라미터에 대한 설명을 넣을때는 옆에 @param 을 넣어야된다.
		// 파라미터를 넣은뒤 문서화주석을 넣으면 java에서 @param을 자동으로 넣어준다.
		
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
	}
	
	
	

}
