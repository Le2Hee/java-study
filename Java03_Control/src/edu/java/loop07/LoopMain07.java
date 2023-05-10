package edu.java.loop07;

public class LoopMain07 {

	public static void main(String[] args) {
		// 2중 반복문
		
		for (int dan = 2; dan<10; dan++) {
			System.out.println("---[" + dan + "단]---");
			for (int n = 1; n < 10; n++) {
//				System.out.println(dan + " x " + n + " = " + (n * dan));
				System.out.printf("%d x %d = %d\n", dan, n, dan * n);
			}
			
		}
		
		System.out.println("\n=============\n");
		
		// while 문을 사용한 구구단 출력
		
		int dan = 2;
		
		while (dan < 10) {
			System.out.println("=== "+dan+"단 ===");
			int n = 1;
			while (n < 10) {
				System.out.printf("%d x %d = %d\n", dan, n, dan*n);
				n++;
			}
			dan ++;
		}
		
		System.out.println("\n=================================\n");
		
		// 해석 
		int x = 2;
		// int y = 1; 여기에다가 변수 값을 설정하면 한 바퀴돌고 y 값이 10으로 고정된다.
		while (x < 10) {
			System.out.println("=== " + x + "단 ===");
			
			// 구구단 출력
			int y = 1; //변수 값 위치 잘생각하기.
			// while 밖에서 int y = 1;를 선언해도 while 안에서 y=1; 를 선언하면 가능.
			while (y < 10) {
				System.out.printf("%d x %d = %d\n", x, y, x * y);
				y++;
			}
			x++;
		}
		
		System.out.println();
		
		
		
		
		
		
	}

}
