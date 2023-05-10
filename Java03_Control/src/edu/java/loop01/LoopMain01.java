package edu.java.loop01;

public class LoopMain01 {

	public static void main(String[] args) {
		// 반복문 필요성 (일정한 규칙이 있으면 만들수있다.)
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		
		System.out.println("================");
		
		// for 반복문
		for (int n = 1; n<=5; n++) {  //()쓴 변수는 for 안에서 실행되고 끝나면 없어진다.
			System.out.println(n);
		}
		
		// 증가 연산자(++), 감소 연산자(--) : 변수의 값을 1 증가/감소. (변수 앞/뒤 에 써도됨 두개가 약간의 차이가있음)
		// 증가/감소 연산자는 변수 앞 또는 뒤에 사용. (예) x++, ++x
		
		System.out.println("===========");
		
		// 10부터 1까지 내림차순으로 출력.
		
		// 내 답지
		for (int m = 10; m>=1; m--) {
			System.out.println(m);
		}
		
		System.out.println("================");
		
		// 답
		for (int n = 10; n > 0; n--) {
			System.out.println(n);
		}
		
		// 지역 변수(local variable) : 메서드 블록({}) 안에서 선언한 변수
		// 지역 변수는 선언된 위치에서 부터 그 변수가 속한 블록 ({}) 안에서만 사용 가능.
		// for() 구문에서 선언하는 변수는 for 블록 안에서만 사용 가능한 지역변수이다.
		
		// 한줄 자체를 주석으로 쓰고싶을땐 ctrl + / 하면 커서가 있는 줄이 주석이 생김, 다시 하면 없어짐
		// ctrl + / : 커서가 있는 줄(또는 선택된 줄) 주석 토글
//		System.out.println(1234);
		
		
		
	}

}
