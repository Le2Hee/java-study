package edu.java.loop10;

import java.util.Scanner;

public class LoopMain10 {

	public static void main(String[] args) {
		// 교제 161쪽 예제 7번
		
		boolean run = true; // 선언한 목적 : 프로그램을 계속 실행할지 아니면 종료할지 결정할 변수.
		// run이 true면 계속 실행
		int balance = 0; // 은행 예금 잔고.
		Scanner scanner = new Scanner(System.in);
		
		while (run) { // run = true 이기 때문에 무한루프이다. (false가 되면 멈춘다.)
			System.out.println("----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4,종료");
			System.out.println("----------------------------------");
			System.out.print("선택 > ");
			
			int menu = scanner.nextInt();
			
			switch (menu) {
			case 1:
				System.out.print("예금액 > ");
				int a = scanner.nextInt();
				balance = balance + a;
				// balance += a; = (balance = balance + a;)와 같다.
				break;
			case 2:
				System.out.print("출금액 > ");
				int b = scanner.nextInt();
				balance = balance - b; // balance -= balance - b;
				break;
			case 3:
				System.out.println("잔고 > " + balance);
				break;
			case 4:
				run = false;  // run 이라는 변수가 false가 되면 while의 무한루프가 멈춘다.
				break;
			default :
				System.out.println("메뉴를 잘못 입력했습니다. 다시 선택하세요.");
			}
			
		}
		System.out.println("프로그램 종료");
		
		
	}

}
