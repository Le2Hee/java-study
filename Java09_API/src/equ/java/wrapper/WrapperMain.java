package equ.java.wrapper;

import java.math.BigDecimal;

// Wrapper 클래스 : -> 감싸주는 클래스
  // Java의 기본 타입의 값 하나를 저장하는(감싸는) 클래스.
  // 만들어진 이유 : 
    // 기본 타입은 메서드를 호출할수 없다. 
    // 저장되어 있는 숫자들을 가지고 메서드를 이용할려면 클래스가 있어야되고, 메서드 등이 필요하다.
  // Wrapper클래스는 java.lang 패키지에 포함디어 있기 때문에 import 문장을 생략해도 된다.

// Wrapper 클래스 사용 목적 : 
  // 1. 기본 데이터 타입의 값을 이용하는 메서드를 제공하기 위해서.
  // 2. 클래스가 있으면 상속/다형성과 같은 객체지향 개념들을 이용하기 위해서.
  // 3. generic 클래스를 사용하기 위해서.

  // Java의 기본 타입 : 
    // boolean, byte, short, int, long, char, float, double
  // Wrapper :  -> Wrapper클래스 이름 : 
    // Boolean, Byte, Short, Integer, Long, Character, Float, Double

public class WrapperMain {

	public static void main(String[] args) {
		int x = 1; // 기본 타입 (primitive type) -> 메서드가 없다.
		
		// Integer 생성하는 방법. (다른것도 똑같다.)
		// Integer 타입의 객체 생성.
		  // 생성자는 권장하지 않고, static 메서드 사용을 권장한다.
//		new Integer 
		// -> Ctrl + 스페이스 를 하면 deprecated되어 있는 (대각선으로 선이 끄어져있는) 가능하면
		//    사용을 권장하지 않다.
		
		// valueOf(); 를 많이 사용한다.
		Integer number1 = Integer.valueOf(1);
		// -> int 값 -> Integer 객체로 만들어 준다.
		// -> 1이라는 기본 타입 데이터를 Integer타입으로 저장하겠다.
		System.out.println(number1);
		
		Integer number2 = Integer.valueOf("123");
		System.out.println(number2); 
		// String -> Integer 객체로 만들어 준다.
		
		// auto-boxing (auto-Wrapper)라고도 하지만 boxing을 더 많이 사용.
		Integer number3 = 1; // Integer.valueOf(1); 코드가 자동실행.
		// -> 사실 말이 안되는 코드이다.
		// -> 1은 숫자인데 Integer이라는 객체에 넣겠다는게 타입이 맞지 않아 말이 안된다.
		// -> Integer number3 = Integer.valueOf(1); 코드가 자동으로 호출이 되는 것이다.
		// -> 이 과정을 auto-boxing 이라고 한다.
		// int 타입 값을 Integer 타입 객체로 자동 변환.
		
		// unboxing
		int y = number3.intValue(); // Integer 타입 객체에서 int 타입 값을 추출.
		System.out.println(y);
		
		// auto-unboxing
		  // Integer 타입 객체가 자동으로 int 타입 값으로 변환.
		int z = number3; // number3.intValue();이 자동 실행.
		
		int add = number1 + number2;
		System.out.println(add);
		
		
		
		int num = Integer.parseInt("100");
		System.out.println(num);
		
		Double.parseDouble("3232.3232");
		System.out.println(Double.parseDouble("3232.3232"));
		
		// float, doulbe 타입은 소수점 이하의 오차가 생길 수 있다.
		double d1 = 1.1;
		double d2 = 0.9;
		System.out.println(d1 - d2); // 1.1 - 0.9 = 0.2
		// -> 결과값이 0.20000000000000007이라고 나온다.
		
		// 실수 타입의 오차를 원하는 수준까지 작게 줄여서 계산에 사용할 수 있는 클래스.
		BigDecimal big1 = new BigDecimal("1.1"); // -> 문자열을 넘겨야 오차률이 줄어든다.
		// -> import 해야됨.
		BigDecimal big2 = new BigDecimal("0.9");
		System.out.println("big1 : " + big1);
		System.out.println("big2 : " + big2);
		System.out.println(big1.subtract(big2)); // -> 오류남. Wrapper클래스가 아니다.
		                  //  -> 메소드를 이용해서 계산해야된다.
		
		// BigDecimal 타입의 객체는 메서드를 호출해서 산술 연산(+, -, *, /)을 수행한다.
		 // BigDecimal 클래스는 기본 타입의 Wrapper클래스가 아니기 때문에
		 // auto=boxing, unboxing 기능이 없다.
		
		
	}

}
