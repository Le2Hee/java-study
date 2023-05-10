package edu.java.inheritance06;

public class StringTest {

	public static void main(String[] args) {
		// 상수(constant) : 
		  // final로 선언된 변수
		
		// 리터럴(literal) :  
		  // 만들어진 값.
		
		final int x = 1;
		// -> x = 상수, 1 = 정수 리터럴.
		long y = 10000000000L;
		// -> 그냥 하면 안된다. heep 자체에 100억이라는 숫자를 만들 수 없기 때문이다.
		// 1000000000뒤에 L을 붙히면 heep 부분에 8byte로 숫자를 만들어라 라는 뜻으로 만든다.
		
		// 문자열 리터럴은 독특한 특징을 가지고 있다.
		String s1 = "hello"; // ->  s1 : 변수, "hello" : 문자열 리터럴
		String s2 = "hello"; // ->
		System.out.println(s1 == s2);  // -> true
		                               // -> JVM은 같은 문자열 리터럴은 두 번 생성하지 않음.
		// heep에 String 객체가 만들어 져야된다.
		// 객체를 만들려면 hello로 만들어진 리터럴이 있어야,
		//   문자열 객체를 찾아가는 지역 변수를 만들 수 있다.
		// java가 String s1 = "hello"; 를 보고 heep에 리터럴을 만들어낸다.
		// 그 리터럴 주소값을 s1에 저장한다.
		// s2도 "hello"의 똑같은 리터럴을 만들까?
		// -> 만들어져 있는 리터럴을 재활용을 한다.
		// -> 그 주소값을 그대로 s2에 전해준다.
		// -> 그래서 ==연산자를 사용할때 true가 나온다.
		
		String s3 = new String("hello");
		String s4 = new String("hello");
		System.out.println(s3 == s4); // -> false
									  // -> 생성자는 호출할때 마다 새로운 객체를 heep 메모리에
		  							  //    새롭게 생성을 한다.
		// 그런데 생성자를 부르면 어떻게 되는 것인가?
		// 생성자는 항상 새로 만들어 준다.
		// new 가 들어가기 때문에 새로 하나를 더 만들어라 라는 뜻을 가진다.
		// 리터럴을 재사용하는 것이 아닌 하나를 더 만들기 때문에 주소값이 달라져 false가 나오는 거다.
		
		// 어떻게 String을 사용해서 값을 호출한지 모르기 때문에 false와 true가 나올지 모른다.
		// -> 문자열에서는 ==연산자를 사용하지 않는다.
		
		// 객체는 변수에 들어가는게 주소값이고
		//  int, ... 는 숫자를 만드는게 아니라 저장되어 있는 레터럴주소를 복사해서 들고 오는 거다.
		//  -> 정수, 실수, boolean
		
		// 결론 -> 문자열 사용할때는 == 연산자 사용하지 말자. equals를 사용하자!!
		
		
	}

}
