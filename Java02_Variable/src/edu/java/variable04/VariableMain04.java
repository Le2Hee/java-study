package edu.java.variable04;

import java.util.Scanner; // 기본 타입이 아닌경우 import로 들고와야한다.

public class VariableMain04 {

	public static void main(String[] args) {
		// 콘솔 창에서 키보드로 정수를 입력받아서 변수에 저장하는 방법.
		// 1. Scanner 타입의 변수를 선언하고 초기화.
		Scanner sc = new Scanner (System.in);
		
		System.out.println("첫번째 정수 입력>>> ");
		
		// 2. Scanner 객체를 사용해서 콘솔 창에서 정수를 입력받고 변수에 저장.(정수를 저장할수있는 변수가 필요하다.)
		int x = sc.nextInt(); // nextInt : 콘솔 창에서 입력된 정수를 입력받아라.
		System.out.println("x = " + x); // 콘솔 창에 오른쪽 상단에 빨간불이 들어온다. (아직 main출력이 끝나지 않기때문이다.)
		// 콘솔 창에서 입력후 Enter를 하면 입력된 정수를 받아 16번을 진행해 입력한다.
		/*
		 * 내 답지
		 * System.out.println("두번째 정수를 입력>>> ");
		 * // 변수 y에 입력받은 정수를 저장.
		 * // x + y, x - y, x * y, x / y, x % y 결과를 출력.
		 * int y = sc.nextInt();
		 * System.out.println("y = " + y);
		 * int plus = x+y;
		 * int minus = x-y;
		 * int multiply = x*y;
		 * int divide = x/y;
		 * int remainder = x%y;   // a%b : a에 b를 나눴을때 나오는 나머지
		 * System.out.println("=======================");
		 * System.out.println("x + y : " + plus);
		 * System.out.println("x - y : " + minus);
		 * System.out.println("x * y : " + multiply);
		 * System.out.println("x / y : " + divide);
		 * System.out.println("x % y : " + remainder);
		 * System.out.println("=======================");
		 */
		
		// 밑에는 선생님 정답
		System.out.println("두번째 정수를 입력>>> ");
		
		// 변수 y에 입력받은 정수 저장
		int y = sc.nextInt();  // int 대신 double 을 넣으면 실수 계산가능 nextDouble로 넣어야됨.
		
		// 입력받은 정수 y를 출력.
		System.out.println("y = "+y);
		
		// x + y, x - y, x * y, x / y, x % y 결과를 출력.
		// 사칙연산 결과를 저장할 변수를 선언하고 덧셈 결과를 저장.
		
		System.out.println("=======================");
		
		int result;
		
		result = x + y; // result 에 x + y를 저장하겠다. (한줄로도가능)
		System.out.println("+ : " + result);
		
		result = x - y; // 위에서 선언한 변수에다가 새로운 값을 저장
		System.out.println("- : " + result);
		
		result = x * y;
		System.out.println("* : " + result);
		
		result = x / y;  // (정수) / (정수) = 나눈 몫
		System.out.println("/ : " + result);
		
		result = x % y;
		System.out.println("% : " + result);
		// 나누기 연산자 : 
		// 1. (정수) / (정수) = 나눈 몫
		// 2. (실수) / (실수) = 소수점까지 계산 (double)
		// (실수) / (정수) 또는 (정수) / (실수)도 2번 계산 결과와 같음.
		
		System.out.println("=======================");
		
		// System.out.println(" + : "+(x+y)); 라고 하면 ()안에 먼저 계산을 하기 때문에 덧셈이 된다.
		
	}

}
