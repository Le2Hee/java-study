package edu.java.loop09;

import java.util.Random;

public class LoopMain09 {

	public static void main(String[] args) {
		/* 문제 1. 아래와 같이 출력하세요..
        *
        **
        ***
        ****
        *****
      */
     
     /* 문제 2. 아래와 같이 출력하세요.
        *
        **
        ***
        ****
        *****
        ****
        ***
        **
        *
      */

     /* 문제 3. 주사위 2개를 던졌을 때 나오는 주사위 눈을 (x, y) 형식으로 출력하세요.
        두 눈의 합이 5가 되면 출력을 멈추세요.
        힌트: Random 타입의 nextInt(start, end) 메서드를 사용.
        출력 결과 예시:
        힌트 1 : Random 타입의 nextInt (stary, end) 메서드를 사용
        힌트 2 : 무한 루프 : for (; ; ){...}, while (true) {...}
        (2, 4)
        (6, 1)
        (3, 3)
        (4, 1)
      */
		// 풀이 ( 내풀이 -> Homework033)
		
		// 문제 1
		
		System.out.println("문제 1번");
		
		// for 문
		for (int x = 1; x <= 5; x++) {
			for (int y = 1; y <= x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// Ctrl+Shift+F : 소스 코드 포맷팅(자동 정렬)
		
		System.out.println("==== while문 ====");
		// while 문
		int line = 1;
		while (line <= 5) {
			int count = 1;
			while (count <= line) {
				System.out.print("*");
				count++;
			}
			System.out.println();
			line++;
		}
		
		
		System.out.println("\n======\n");
		
		
		System.out.println("문제 2번");
		
		// 5개 따로 출력하는 방법
//		for (int x = 1; x<=5; x++) {
//			for (int y= 1; y <= x; y++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
//		for (int x = 4; x >= 1; x--) {
//			for (int y = 1; y <= x; y++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		// 윗 코드를 다른 코드로
		
//		for (int x = 1; x <= 4; x++) {
//			for (int y = 4; y >= x; y--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		// 윗 코드를 다른 코드로
		
//		for (int x = 6; x  <= 9; x++) {
//			for (int y = 4; y >= x - 5; y--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		// 하나로 코드 짜기
		
		for (int x = 1; x <= 9; x++) {
			if (x <= 5) { // *를 하나씩 늘려감
				for (int y = 1; y <= x; y++) {
					System.out.print("*");
				}
			} else { // *를 하나씩 줄여감
				for (int y = 4; y >= x - 5; y--) {
					System.out.print("*");
				}
			}
			System.out.println(); // if를 하든 else를 하든 줄바꿈 하기 때문에 굳이 2개를 넣지않고 여기에 넣으면 된다. 
		}
		
		
		System.out.println("\n==========\n");
		
		
		System.out.println("문제 3번");
		
		Random rand = new Random();
		
		// for (;;) {  // 무한루프로 만들어 안에서 변수를 선언한다.
		while (true) { // while 로 무한루프 만들기 ( true 가 항상) : 항상 실행하겠다.
			int dice1 = rand.nextInt(6) + 1;
			int dice2 = rand.nextInt(1, 7); // 1 <= r <7 이다.
			System.out.printf("(%d),(%d)\n", dice1, dice2);
			if ( dice1 + dice2 == 5) {
				break;
			}
		}
		
		
		
		
		
		
	}

}
