package equ.java.exception06;

import java.util.Scanner;


public class ExceptionMain06 {
	
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// inputInteger() 메서드 테스트 코드
		ExceptionMain06 x = new ExceptionMain06();
		x.inputInteger();
		
		
	}
	
	public int inputInteger() {
		// Scanner를 사용해서 입력받은 정수를 리턴.
		// Integer.parseInt(scanner.nextLine());과제에서 NumberFomatException이 발생할 수 있음.
		int x;
		for( ; ; ) {
			try {
				System.out.print("정수를 입력하세요 >>> ");
				x = Integer.parseInt(scanner.nextLine());
				System.out.println("입력하신 정수는 : " + x + "입니다.");
				break;
			} catch (NumberFormatException e) {
				System.out.println("정수를 다시 입력하세요.");
			}
			
		}
		
		return x;
	}

}
