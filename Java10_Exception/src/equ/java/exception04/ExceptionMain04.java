package equ.java.exception04;

import java.util.Scanner;

public class ExceptionMain04 {

	public static void main(String[] args) {
		// multi - catch 블록 (Java 7 버전부터)
		// 하나의 catch 블록에서 여러개의 예외들을 처리하기 위한 문법.
		
		// Exception을 여러개 처리를 할때에
		// -> 일반적으로 try - catch를 사용하는데 multi-catch는 catch를 여러개 사용하는 것이
		//    불편해서 한번에 처리를 하고 싶어서 만든 문법.
		
		// 사용 방법 : 
		  // catch(Exception1 | Exception2 | ... 변수) {...}
		  // -> | 을 사용하지만 1개만 사용.
		
		// 주의! : 
		// multi-catch 블록은 상속 관계(Super-Sub관계)에 있는 예외 클래스들은 함꼐 사용할 수 없다! 
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("x를 입력하세요. >>> ");
			int x =  Integer.parseInt(sc.nextLine());
			
			System.out.print("y를 입력하세요. >>> ");
			int y = Integer.parseInt(sc.nextLine());
			
			System.out.printf("%d / %d = %d\n", x, y, x / y);
			
		} catch (NumberFormatException | ArithmeticException e) { // Exception을 넣으면 상속관계
			System.out.println(e.getMessage());                   // 이기때문에 안된다.
			
		}
		
		
		
	}

}
