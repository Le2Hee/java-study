package equ.java.exception02;

import java.util.Scanner;

/*
 * try-catch 구문을 사용한 예외 처리 : 
 * 
 * try {
 *     (1) 실행할 코드들.
 * } catch (Exception 타입 변수 선언) {
 *     (2) 예외가 발생했을 때 실행할 코드.   
 * } finally {
 *     (3) 예외 발생 여부와 상관없이 항상 실행할 코드들.
 *     -> try 블록이 모두 끝났을 때 or catch 블록이 모두 끝났을 때 실행할 코드들.
 * }
 * 
 *  - 예외가 발생하지 않을 경우 : (1) -> (3)
 *  - 예외가 발생할 경우 : (1)실행 중에 예외 발생 -> (2) -> (3)
 *  - 발생한 예외를 catch할 수 없으면 catch 블록이 실행되지 못하고 프로그램은 비정상적으로 종류된다.
 *  - catch블록은 발생할 수 있는 예외 종류에 따라서 여러개를 작성할 수도 있음.
 *  - finally 블록은 선택 사항이다. (필수가 아니다.)
 *  - try 블록과 catch 블록은 필수적으로 사용해야 된다.
 *  
 *  참고
 *  예외 클래스의 상속 관계 : 
 *  Object
 *  |__Throwable
 *     |__Exception
 *         |__RuntimeExrption (수 많은 Exception 들이 있고 그 중 하나)
 *            |__ArithmetiException, NullPointExceptionm, ArryIndexOutOfBoundsException, ...
 *  다형성을 이용해 Exception을 이용해 모든 SupType들을 저장할 수 있다.
 *            
 *  - catch 블록이 여러개일 때는 하위 타입의 예외들을 먼저 catch하고,
 *    상위 타입의 예외들은 나중에 catch해야 한다. 
 *  
 */

public class ExceptionMain02 {

	public static void main(String[] args) {
		// 정수를 입력받아서 나누기 결과를 출력할때 발생할수 있는 Exception들을 찾아서
		// try-catch로 잡기
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("x 입력 하세요 >>> ");
			int x = Integer.parseInt(sc.nextLine());
			
			System.out.print("y 입력 하세요 >>> ");
			int y = Integer.parseInt(sc.nextLine());
			
			int result = x / y;
			System.out.println("x / y 몫 = " + result);
		} catch (ArithmeticException e) { // ArithmeticException e 는 파라미터 선언이랑 비슷하다고 생각하기.
			System.out.println("Y는 0이 될 수 없습니다. ");
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); // -> 에러문구가 나온다.
		} catch (Exception e) { // Exception 클래스의 모든 하위 타입 예외들을 처리할 수 있다.
			// 주의 : 
			// 상위 타입의 Exception을 사용하면 catch의 순서를 바꿔 버리면 Exception을 먼저 
			// 잡아버리면 위에서 다 잡아버려 원하는 코드가 출력이 안된다.
			// -> 순서가 위에서 아래로 간다.
			e.printStackTrace();
		}
		
		System.out.println("프로그램 정상 종료");
		
		
	}

}
