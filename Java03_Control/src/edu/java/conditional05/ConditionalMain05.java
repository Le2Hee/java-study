package edu.java.conditional05;

import java.util.Random;  // import 문장은 java.util 패키지의 Random 타입을 사용하겠다.

public class ConditionalMain05 {

	public static void main(String[] args) {
		// 난수(random number) 만드는 방법 : 
		Random random = new Random(); // Random 타입의 변수를 선언하고 초기화.  // new Random 스케너 기계를 random에 저장하겠다.
		int x = random.nextInt(5); // 0이상 5미만의 정수 난수를 만들어준다.
		System.out.println("x = "+x);
		
		int y = random.nextInt(5);
		System.out.println("y = "+y);
		
		// int 타입의 bigger 변수에 x와 y 중에서 더 큰 수를 저장. 
		
		//내 답지
		if (x > y) {
			int bigger = x;
			System.out.println("x가 더 크다.");
			System.out.println("bigger = "+bigger);
		} else {
			int bigger = y;
			System.out.println("Y가 더 크다.");
			System.out.println("bigger = "+bigger);
		}
		
		/*
		 * 답지
		 * int bigger = 0;
		 * if (x>y) {
		 *  	bigger = x;
		 * } else {
		 *  	bigger = y;
		 * }
		 * system.out.println("bigger = "+bigger);
		*/
		// 삼항 연산자 bigger2 와 위에서 사용한 if = bigger이랑 같다.
		// 삼항 연산자 : ?와:를 사용하는 것 
		int bigger2 = (x>y) ? x : y;
		System.out.println("bigger2 = "+bigger2);
		
		// int 타입의 diff 변수에 x와 y의 차이(|x-y|)를 저장.
		
		// 내 답
		//if 문
		/*
		 * int diff = 0;
		if (x>y) {
			diff = x-y;
		} else {
			diff = y-x;
		}
		System.out.println("diff = "+diff);
		
		// 삼항 연산자
		int diff2 = ((x>y)?x:y) - ((x<y)?x:y);
		System.out.println("diff = "+diff2);
		*/
		
		// 답
		//if
		int diff = 0;
		if (x>y) {
			diff = x-y;
		} else {
			diff = y-x;
		}
		System.out.println("diff = "+diff);
		
		// 삼항 연산자
		int diff2 = (x>y)?x-y:y-x;
		System.out.println("diff2 ="+diff2);
		
		// 10 이하의 정수 난수를 만들어서 변수number에 저장.
		// String 타입 변수 evenOrOdd에 number가 짝수이면 "짝수", 홀수이면 "홀수" 문자열 저장
		
		/* 내 답
		int number = random.nextInt(11);
		System.out.println("number ="+number);
		String evenOrOdd = (number%2==0)?"짝수":"홀수";
		System.out.println("evenOrOdd = "+evenOrOdd);
		*/
		
		// 답
		int number = random.nextInt(11);
		System.out.println("number = "+number);
		String evenOrOdd = "";  // 문자열 String 타입의 변수를 선언하고 초기화.
		// if문
		if (number%2==0) {
			evenOrOdd = "짝수";
		} else {
			evenOrOdd = "홀수";
		}
		System.out.println("number = "+evenOrOdd);
		
		// 삼항 연산자
		String evenOrOdd2 = (number%2==0)?"짝수":"홀수";
		System.out.println("number = "+evenOrOdd2);
		
	}

}
