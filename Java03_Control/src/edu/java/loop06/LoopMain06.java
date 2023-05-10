package edu.java.loop06;

public class LoopMain06 {

	public static void main(String[] args) {
		// do-while 반복문
		
		// 1 2 3 4 5 6 7 8 9 10		
		int n = 1;
		do { // do는 무조건 실행을 해라 라는 의미.
			System.out.print(n + " ");
			n++;
		} while (n <= 10); // while가 반복할까 말까 검사 -> 다시 do로 반복
		
		System.out.println();
		
		// do-while 문은 반복 여부를 검사하기 전에 무조건 블록을 한 번 실행한다.!!!!!
		// for문과 while 문은 블록을 실행하기전에 반복여부를 먼저 검사하고, 조건이 참이면 블록을 실행한다.
		// 설명을 위한 예제)
		n = 1;
		while (n < 5) {
			System.out.print(n+" ");
			n++;
		}
		
		System.out.println();
		
		n = 1;
		
		do {  // 출력을 하고 조건을 검사하는 것이 while문 과 차이점이다.
			System.out.print(n + " ");
			n++;
		} while (n > 5);
		
		System.out.println();
		
		// for, while, do-while 문 중에서 for의 비중이 제일 많다.
		
		
		
		
		
	}

}
