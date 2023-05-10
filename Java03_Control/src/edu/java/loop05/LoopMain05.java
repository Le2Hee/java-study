package edu.java.loop05;

public class LoopMain05 {

	public static void main(String[] args) {
		// 1 ~ 10 정수들을 오름차순으로 한 줄에 출력 
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		// while 반복문
		// while는 () 안에 ; 이 들어가면 안된다.
		int n = 1;
		while (n <= 10) { // n이 10보다 작거나 같을 동안에 실행하겠다.
			System.out.print(n + " "); // 출력
			n++; // 출력 후 ++ 을 한다. -> while() 을 검사하고 다시 반복
			// n++; 를 안쓰는 실수를 많이 한다. // 없으면 무한루프라고 한다.
		} 
		
		System.out.println();
		
		// 출력 결과 : 1 3 5 7 9 (for문과 while문 2가지로 작성)
		
		System.out.println("===내 답안===");
		
		System.out.println("<for문>");
		for (int x = 1; x < 10; x++) {
			if (x % 2== 1) {
				System.out.print(x + " ");
			}
		}
		
		System.out.println();
		
		System.out.println("<while문>");
		int x = 1;
		while (x < 10) {
			if (x % 2 == 1) {
				System.out.print(x + " ");
			}
			x++;
		}
		
		System.out.println();
		
		System.out.println("=====풀이=====");
		
		System.out.println("<for문>");
		
		for (int i = 1; i < 10; i += 2) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		System.out.println("<while문>");
		
		n = 1;
		while (n < 10) {
			System.out.print(n + " ");
			n += 2;
		}
		
		System.out.println();
		
		n = 1;
		while (n < 10) {
			if (n % 2 == 1) {
				System.out.print(n+" ");
			}
			n++;
		}
		
		System.out.println();
		
		
		
	}

}
